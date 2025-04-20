package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.PagoDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de pagos.
 */
public interface IPagoService {
    void insert(PagoDTO dto);
    List<PagoDTO> list();
    void delete(int id);
    PagoDTO update(int id, PagoDTO dto);
}
