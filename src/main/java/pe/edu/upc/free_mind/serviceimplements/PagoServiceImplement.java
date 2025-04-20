package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.PagoDTO;
import pe.edu.upc.free_mind.entities.Cita;
import pe.edu.upc.free_mind.entities.Pago;
import pe.edu.upc.free_mind.repositories.ICitaRepository;
import pe.edu.upc.free_mind.repositories.IPagoRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IPagoService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio para la entidad Pago.
 */
@Service
public class PagoServiceImplement implements IPagoService {

    @Autowired
    private IPagoRepository pagoRepository;

    @Autowired
    private ICitaRepository citaRepository;

    @Override
    public void insert(PagoDTO dto) {
        Pago p = new Pago();
        p.setMonto(dto.getMonto());
        p.setMetodo(dto.getMetodo());
        p.setFecha(dto.getFecha());

        Cita cita = citaRepository.findById(dto.getIdCita()).orElse(null);
        p.setCita(cita);

        pagoRepository.save(p);
    }

    @Override
    public List<PagoDTO> list() {
        return pagoRepository.findAll().stream().map(p -> {
            PagoDTO dto = new PagoDTO();
            dto.setIdPago(p.getIdPago());
            dto.setMonto(p.getMonto());
            dto.setMetodo(p.getMetodo());
            dto.setFecha(p.getFecha());
            dto.setIdCita(p.getCita().getIdCita());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        pagoRepository.deleteById(id);
    }

    @Override
    public PagoDTO update(int id, PagoDTO dto) {
        Pago p = pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado con ID: " + id));

        p.setMonto(dto.getMonto());
        p.setMetodo(dto.getMetodo());
        p.setFecha(dto.getFecha());

        Cita cita = citaRepository.findById(dto.getIdCita()).orElse(null);
        p.setCita(cita);

        Pago actualizado = pagoRepository.save(p);

        PagoDTO result = new PagoDTO();
        result.setIdPago(actualizado.getIdPago());
        result.setMonto(actualizado.getMonto());
        result.setMetodo(actualizado.getMetodo());
        result.setFecha(actualizado.getFecha());
        result.setIdCita(actualizado.getCita().getIdCita());

        return result;
    }
}
