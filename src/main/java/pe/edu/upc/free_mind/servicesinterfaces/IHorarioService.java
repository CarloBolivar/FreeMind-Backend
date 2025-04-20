package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.HorarioDTO;

import java.util.List;

/**
 * Interfaz de servicio para gestionar horarios.
 */
public interface IHorarioService {
    void insert(HorarioDTO dto);
    List<HorarioDTO> list();
    void delete(int id);
    HorarioDTO update(int id, HorarioDTO dto);
}
