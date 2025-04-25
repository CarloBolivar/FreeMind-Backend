package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.repositories.IUsuarioRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IUsuarioService;

import java.util.List;

/**
 * Implementación del servicio para la entidad Usuario.
 * Aplica la lógica de negocio y delega a la capa de persistencia.
 */

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;


    /**
     * Repositorio para operaciones CRUD sobre Usuario.
     */
    @Autowired
    private IUsuarioRepository uR;

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param usuario Objeto Usuario a insertar
     */
    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    /**
     * Lista todos los usuarios registrados.
     *
     * @return Lista de objetos Usuario
     */
    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    /**
     * Elimina un usuario según su ID.
     *
     * @param id Identificador del usuario a eliminar
     */
    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id Identificador del usuario a consultar
     * @return Objeto Usuario encontrado o null si no existe
     */
    @Override
    public Usuario listId(int id) {
        return uR.findById(id).orElse(new Usuario());
    }

    /**
     * Actualiza un usuario existente.
     *
     * @param usuario Objeto Usuario con los datos actualizados
     */
    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }
    @Override
    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    /*R*/
    @Override
    public List<String[]> amountByUsuario() { return uR.amountByUsuario(); }
    @Override
    public List<String[]> comentByUsuario() { return uR.comentByUsuario(); }
}


