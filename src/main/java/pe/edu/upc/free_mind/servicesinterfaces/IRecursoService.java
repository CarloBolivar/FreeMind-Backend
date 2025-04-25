package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Recurso;
import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la entidad Recurso.
 * Encapsula la lógica de negocio relacionada a los recursos educativos.
 */
public interface IRecursoService {

    /**
     * Lista todos los recursos registrados.
     * @return Lista de objetos Recurso
     */
    public List<Recurso> list();

    /**
     * Inserta un nuevo recurso en la base de datos.
     * @param recurso Objeto Recurso a registrar
     */
    public void insert(Recurso recurso);

    /**
     * Elimina un recurso por su ID.
     * @param id ID del recurso a eliminar
     */
    public void delete(int id);

    /**
     * Obtiene un recurso por su ID.
     * @param id Identificador buscado
     * @return Objeto Recurso correspondiente o uno nuevo si no existe
     */
    public Recurso listId(int id);

    /**
     * Actualiza un recurso existente.
     * @param recurso Objeto con los nuevos datos
     */
    public void update(Recurso recurso);
}