package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.PreguntaTestDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de preguntas de test.
 */
public interface IPreguntaTestService {
    void insert(PreguntaTestDTO dto);
    List<PreguntaTestDTO> list();
    void delete(int id);
    PreguntaTestDTO update(int id, PreguntaTestDTO dto);
}
