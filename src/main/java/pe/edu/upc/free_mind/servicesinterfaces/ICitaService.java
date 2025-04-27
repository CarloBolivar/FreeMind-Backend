package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Cita;
import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la entidad Cita.
 * Encapsula la lógica de negocio relacionada con el agendamiento de citas.
 */
public interface ICitaService {

    /**
     * Lista todas las citas registradas.
     * @return Lista de objetos Cita
     */
    public List<Cita> list();

    /**
     * Inserta una nueva cita en la base de datos.
     * @param cita Objeto Cita a guardar
     */
    public void insert(Cita cita);

    /**
     * Elimina una cita por su ID.
     * @param id Identificador de la cita
     */
    public void delete(int id);

    /**
     * Obtiene una cita por su ID.
     * @param id ID buscado
     * @return Objeto Cita encontrado o nuevo vacío si no existe
     */
    public Cita listId(int id);

    /**
     * Actualiza una cita existente con nuevos datos.
     * @param cita Objeto Cita actualizado
     */
    public void update(Cita cita);

    /**
     * Obtiene la cantidad de citas atendidas por cada psicólogo.
   */
    public List<String[]> obtenerCantidadCitasPorPsicologo();

    /*Deyci*/
    public List<String[]> QuantityCitaByTerapia();
    public List<String[]> totalIngresosPorPsicologo();

}
