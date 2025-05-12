package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.repositories.IUsuarioRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IUsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

// Implementación del servicio para la entidad Usuario
@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    // Repositorio para operaciones CRUD sobre Usuario
    @Autowired
    private IUsuarioRepository uR;

    //Inserta un nuevo usuario en la base de datos,deja el usuario habilitado y el password encoder encripta la contraseña
    @Override
    public void insert(Usuario usuario) {
        String encriptada = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(encriptada);
        usuario.setEnabled(true);
        uR.save(usuario);
    }

    //Lista todos los usuarios registrados.
    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    //Elimina un usuario según su ID
    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    //Obtiene un usuario por su ID
    @Override
    public Usuario listId(int id) {
        return uR.findById(id).orElse(new Usuario());
    }

    @Override
    public void update(Usuario usuario) {
        String encriptada = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(encriptada);
        uR.save(usuario);
    }
    @Override
    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    //Reportes
    /*Renzo*/
    @Override
    public List<String[]> amountByUsuario() { return uR.amountByUsuario(); }

    @Override
    public List<String[]> cantByUsuario() { return uR.cantidadUsuario(); }

    //Ariam Reportes
    @Override
    public List<String[]> getPsicologosActivos() {
        return uR.getPsicologosActivos();
    }

    //Filtro
    @Override
    public List<Usuario> filtrarUsuarios(String especialidad, Integer idRol) {
        if (especialidad != null && idRol != null) {
            return uR.findByEspecialidadAndRolIdRol(especialidad, idRol);
        } else if (especialidad != null) {
            return uR.findByEspecialidad(especialidad);
        } else if (idRol != null) {
            return uR.findByRolIdRol(idRol);
        } else {
            return uR.findAll();
        }
    }
}


