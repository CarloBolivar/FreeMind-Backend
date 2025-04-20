package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.RecursoDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de recursos multimedia.
 */
public interface IRecursoService {
    void insert(RecursoDTO dto);
    List<RecursoDTO> list();
    void delete(int id);
    RecursoDTO update(int id, RecursoDTO dto);
}
