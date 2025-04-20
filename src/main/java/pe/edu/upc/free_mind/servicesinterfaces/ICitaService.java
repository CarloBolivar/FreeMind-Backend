package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.CitaDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de citas.
 */
public interface ICitaService {
    void insert(CitaDTO dto);
    List<CitaDTO> list();
    void delete(int id);
    CitaDTO update(int id, CitaDTO dto);
}
