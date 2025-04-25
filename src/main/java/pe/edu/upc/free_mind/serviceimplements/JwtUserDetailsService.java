package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.repositories.IUsuarioRepository;

import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findAll()
                .stream()
                .filter(u -> u.getCorreo().equals(correo))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getNombre());
        return new User(
                usuario.getCorreo(),
                usuario.getContrasena(),
                true,  // enabled
                true,  // accountNonExpired
                true,  // credentialsNonExpired
                true,  // accountNonLocked
                Collections.singleton(authority)
        );

        //return new User(usuario.getCorreo(), usuario.getContrasena(), Collections.singleton(authority));
    }
}
