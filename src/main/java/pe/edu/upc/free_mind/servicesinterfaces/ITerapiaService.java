package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.TerapiaDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de terapias.
 */
public interface ITerapiaService {
    void insert(TerapiaDTO dto);
    List<TerapiaDTO> list();
    void delete(int id);
    TerapiaDTO update(int id, TerapiaDTO dto);
}
