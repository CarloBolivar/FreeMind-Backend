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

//Implementación de UserDetailsService para autenticación JWT
@Service
public class JwtUserDetailsService implements UserDetailsService {

    //Repositorio de usuarios para autenticación
    @Autowired
    private IUsuarioRepository usuarioRepository;

    //Carga los datos de usuario por su correo
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe: %s", correo));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuario.getRol().getNombre())); //Rol asociado al usuario

        return new User(
                usuario.getCorreo(),
                usuario.getContrasena(),
                usuario.getEnabled(), //Estado de habilitación
                true, //Cuenta no expirada
                true, //Credenciales no expiradas
                true, //Cuenta no bloqueada
                authorities
        );
    }
}
