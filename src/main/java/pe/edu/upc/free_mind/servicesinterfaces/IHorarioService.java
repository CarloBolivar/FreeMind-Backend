package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Horario;
import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la entidad Horario.
 * Encapsula la lógica de negocio relacionada a los horarios disponibles.
 */
public interface IHorarioService {

    /**
     * Lista todos los horarios registrados.
     * @return Lista de objetos Horario
     */
    public List<Horario> list();

    /**
     * Inserta un nuevo horario en la base de datos.
     * @param horario Objeto Horario a registrar
     */
    public void insert(Horario horario);

    /**
     * Elimina un horario por su ID.
     * @param id ID del horario a eliminar
     */
    public void delete(int id);

    /**
     * Obtiene un horario por su ID.
     * @param id Identificador buscado
     * @return Objeto Horario correspondiente o uno nuevo si no existe
     */
    public Horario listId(int id);

    /**
     * Actualiza un horario existente.
     * @param horario Objeto con los nuevos datos
     */
    public void update(Horario horario);
}