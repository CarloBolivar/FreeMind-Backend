package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.CantidadRecursosPorTerapiaDTO;
import pe.edu.upc.free_mind.entities.Recurso;
import java.util.List;

//Interfaz que define los métodos de servicio para la entidad Recurso
public interface IRecursoService {

    //Lista todos los recursos registrados
    public List<Recurso> list();

    //Inserta un nuevo recurso en la base de datos
    public void insert(Recurso recurso);

    //Elimina un recurso por su ID.
    public void delete(int id);

    //Obtiene un recurso por su ID
    public Recurso listId(int id);

    //Actualiza un recurso existente
    public void update(Recurso recurso);

    //Reportes
    /*Mauricio*/
    List<CantidadRecursosPorTerapiaDTO> cantidadRecursosPorTerapia();

}