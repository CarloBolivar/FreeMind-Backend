package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Cita;
import java.util.List;

//Interfaz que define los métodos de servicio para la entidad Cita
public interface ICitaService {

    //Lista todas las citas registradas
    public List<Cita> list();

    // Inserta una nueva cita en la base de datos
    public void insert(Cita cita);

    //Elimina una cita por su ID.
    public void delete(int id);

    //Obtiene una cita por su ID.
    public Cita listId(int id);

    //Actualiza una cita existente con nuevos datos.
    public void update(Cita cita);

    //Reportes
    /*Carlo*/
    public List<String[]> obtenerCantidadCitasPorPsicologo();

    /*Deyci*/
    public List<String[]> QuantityCitaByTerapia();
    public List<String[]> totalIngresosPorPsicologo();

}
