package pe.edu.upc.free_mind.securities;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.repositories.IUsuarioRepository;

import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.util.*;
import java.util.Base64;
import java.util.function.Function;
import java.util.stream.Collectors;

//Utilidad para gestión de tokens JWT
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    //Validez del token en milisegundos
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    //Obtiene el username contenido en el token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //Obtiene la fecha de expiración del token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    //Obtiene un claim específico del token
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //Obtiene todos los claims del token
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(token).getBody();
    }

    //Verifica si el token ha expirado
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //Genera un nuevo token JWT
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        //Filtra usuario por correo
        Usuario usuario = usuarioRepository.findAll().stream()
                .filter(u -> u.getCorreo().equals(userDetails.getUsername()))
                .findFirst()
                .orElse(null);

        if (usuario != null) {
            claims.put("nombre", usuario.getNombre() + " " + usuario.getApellido());
        }

        claims.put("role", userDetails.getAuthorities().stream()
                .map(r -> r.getAuthority())
                .collect(Collectors.joining()));

        return doGenerateToken(claims, userDetails.getUsername());
    }

    //Construye el token JWT
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512,
                        new SecretKeySpec(Base64.getDecoder().decode(secret),
                                SignatureAlgorithm.HS512.getJcaName()))
                .compact();
    }

    //Valida si el token pertenece al usuario y no ha expirado
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
