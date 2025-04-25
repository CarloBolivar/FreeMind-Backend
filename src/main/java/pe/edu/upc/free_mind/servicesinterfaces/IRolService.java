package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Rol;
import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la entidad Rol.
 * Utilizada para declarar la lógica de negocio desacoplada del controlador.
 */
public interface IRolService {

    /**
     * Lista todos los roles registrados.
     * @return Lista de objetos Rol
     */
    public List<Rol> list();

    /**
     * Inserta un nuevo rol en la base de datos.
     * @param rol Objeto Rol a registrar
     */
    public void insert(Rol rol);

    /**
     * Elimina un rol por su ID.
     * @param id ID del rol a eliminar
     */
    public void delete(int id);

    /**
     * Obtiene un rol por su ID.
     * @param id ID del rol buscado
     * @return Objeto Rol encontrado o nuevo Rol vacío si no existe
     */
    public Rol listId(int id);

    /**
     * Actualiza un rol existente en la base de datos.
     * @param rol Objeto Rol con los datos actualizados
     */
    public void update(Rol rol);
}