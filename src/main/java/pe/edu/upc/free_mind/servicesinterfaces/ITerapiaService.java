package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.MontoPorTipoDeTerapiaDTO;
import pe.edu.upc.free_mind.entities.Terapia;
import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la entidad Terapia.
 * Encapsula la lógica de negocio relacionada a las terapias.
 */
public interface ITerapiaService {
    /**
     * Lista todas las terapias registradas.
     * @return Lista de objetos Terapia
     */
    
 List<MontoPorTipoDeTerapiaDTO> obtenerMontoTotalPorTipoTerapia();

    
    public List<Terapia> list();

    /**
     * Inserta una nueva terapia en la base de datos.
     * @param terapia Objeto Terapia a registrar
     */
    public void insert(Terapia terapia);

    /**
     * Elimina una terapia por su ID.
     * @param id ID de la terapia a eliminar
     */
    public void delete(int id);

    /**
     * Obtiene una terapia por su ID.
     * @param id Identificador buscado
     * @return Objeto Terapia correspondiente o uno nuevo si no existe
     */
    public Terapia listId(int id);

    /**
     * Actualiza una terapia existente.
     * @param terapia Objeto con los nuevos datos
     */
    public void update(Terapia terapia);
}
