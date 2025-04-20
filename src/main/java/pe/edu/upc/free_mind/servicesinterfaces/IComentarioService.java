package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.ComentarioDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de comentarios.
 */
public interface IComentarioService {
    void insert(ComentarioDTO dto);
    List<ComentarioDTO> list();
    void delete(int id);
    ComentarioDTO update(int id, ComentarioDTO dto);
}
