package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Comentario;
import java.util.List;

//Interfaz que define los métodos de servicio para la entidad Comentario
public interface IComentarioService {

    //Lista todos los comentarios registrados
    public List<Comentario> list();

    //Inserta un nuevo comentario en la base de datos
    public void insert(Comentario comentario);

    //Elimina un comentario por su ID
    public void delete(int id);

    //Obtiene un comentario por su ID.
    public Comentario listId(int id);

    //Actualiza un comentario existente.
    public void update(Comentario comentario);
}
