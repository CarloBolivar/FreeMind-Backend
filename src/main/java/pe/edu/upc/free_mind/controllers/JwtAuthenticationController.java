package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.securities.JwtRequest;
import pe.edu.upc.free_mind.securities.JwtResponse;
import pe.edu.upc.free_mind.securities.JwtTokenUtil;
import pe.edu.upc.free_mind.serviceimplements.JwtUserDetailsService;
import pe.edu.upc.free_mind.servicesinterfaces.IUsuarioService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest req) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getCorreo(), req.getContrasena())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciales inválidas", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getCorreo());
        final String token = jwtTokenUtil.generateToken(userDetails);

        Usuario usuario = userDetailsService.findByCorreo(req.getCorreo());
        String rol = usuario.getRol().getNombre();
        String nombreUsuario = usuario.getNombre();

        JwtResponse response = new JwtResponse(token, rol, nombreUsuario);
        return ResponseEntity.ok(response);
    }
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        // Validar que solo se registren PACIENTE o PSICOLOGO
        String nombreRol = usuario.getRol().getNombre().toUpperCase();
        if (!nombreRol.equals("PACIENTE") && !nombreRol.equals("PSICOLOGO")) {
            return ResponseEntity.status(403).body(" No está permitido registrar este tipo de rol.");
        }

        usuario.setEnabled(true);

        Usuario nuevo = usuarioService.insert(usuario);
        return ResponseEntity.ok(nuevo);
    }


    private void authenticate(String correo, String contrasena) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(correo, contrasena)
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
