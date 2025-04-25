package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Comentario;
import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la entidad Comentario.
 * Encapsula la lógica de negocio relacionada a los comentarios realizados por usuarios.
 */
public interface IComentarioService {

    /**
     * Lista todos los comentarios registrados.
     * @return Lista de objetos Comentario
     */
    public List<Comentario> list();

    /**
     * Inserta un nuevo comentario en la base de datos.
     * @param comentario Objeto Comentario a registrar
     */
    public void insert(Comentario comentario);

    /**
     * Elimina un comentario por su ID.
     * @param id ID del comentario a eliminar
     */
    public void delete(int id);

    /**
     * Obtiene un comentario por su ID.
     * @param id Identificador buscado
     * @return Objeto Comentario correspondiente o uno nuevo si no existe
     */
    public Comentario listId(int id);

    /**
     * Actualiza un comentario existente.
     * @param comentario Objeto con los nuevos datos
     */
    public void update(Comentario comentario);
}
