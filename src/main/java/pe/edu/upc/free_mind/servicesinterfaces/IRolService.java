package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.RolDTO;

import java.util.List;

/**
 * Interfaz que define los métodos del servicio Rol.
 */
public interface IRolService {
    void insert(RolDTO dto);
    List<RolDTO> list();
    void delete(int idRol);
    RolDTO update(int id, RolDTO dto);
}
