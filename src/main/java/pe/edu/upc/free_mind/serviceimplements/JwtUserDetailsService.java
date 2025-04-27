package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que implementa UserDetailsService para autenticación JWT.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe: %s", correo));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuario.getRol().getNombre())); //  rol en Usuario

        return new User(
                usuario.getCorreo(),
                usuario.getContrasena(),
                usuario.getEnabled(), // campo enabled
                true,  // accountNonExpired
                true,  // credentialsNonExpired
                true,  // accountNonLocked
                authorities
        );
    }
}
