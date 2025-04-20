package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.RespuestaTestDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de respuestas de test.
 */
public interface IRespuestaTestService {
    void insert(RespuestaTestDTO dto);
    List<RespuestaTestDTO> list();
    void delete(int id);
    RespuestaTestDTO update(int id, RespuestaTestDTO dto);
}
