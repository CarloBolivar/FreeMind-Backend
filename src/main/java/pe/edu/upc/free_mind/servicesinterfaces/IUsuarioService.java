package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Usuario;

import java.util.List;

/**
 * Interfaz que define los servicios relacionados a la entidad Usuario.
 * Permite realizar operaciones CRUD y reportes específicos sobre los usuarios del sistema.
 */
public interface IUsuarioService {

    /**
     * Lista todos los usuarios registrados en el sistema.
     *
     * @return Lista de objetos Usuario.
     */
    public List<Usuario> list();

    /**
     * Inserta un nuevo usuario en el sistema.
     *
     * @param usuario Objeto Usuario que se desea registrar.
     */
    public void insert(Usuario usuario);

    /**
     * Elimina un usuario específico del sistema basado en su ID.
     *
     * @param id Identificador único del usuario que se desea eliminar.
     */
    public void delete(int id);

    /**
     * Busca un usuario en el sistema basado en su ID.
     *
     * @param id Identificador único del usuario a buscar.
     * @return Objeto Usuario correspondiente al ID proporcionado, o null si no existe.
     */
    public Usuario listId(int id);

    /**
     * Actualiza los datos de un usuario existente en el sistema.
     *
     * @param usuario Objeto Usuario con la información actualizada.
     */
    public void update(Usuario usuario);

    /**
     * Busca un usuario en el sistema utilizando su correo electrónico.
     *
     * @param correo Correo electrónico del usuario a buscar.
     * @return Objeto Usuario correspondiente al correo proporcionado, o null si no existe.
     */
    public default Usuario findByCorreo(String correo) {
        return null;
    }

    /**
     * Reportes
    */
    /* Renzo*/
    public List<String[]> amountByUsuario();
    public List<String[]> comentByUsuario();
}
