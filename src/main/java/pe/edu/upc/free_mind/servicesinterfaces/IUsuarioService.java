package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.UsuarioDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de usuarios.
 */
public interface IUsuarioService {
    void insert(UsuarioDTO dto);
    List<UsuarioDTO> list();
    void delete(int id);
    UsuarioDTO update(int id, UsuarioDTO dto);
}
