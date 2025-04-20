package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.TerapiaDTO;
import pe.edu.upc.free_mind.entities.Terapia;
import pe.edu.upc.free_mind.repositories.ITerapiaRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ITerapiaService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio para la entidad Terapia.
 */
@Service
public class TerapiaServiceImplement implements ITerapiaService {

    @Autowired
    private ITerapiaRepository terapiaRepository;

    @Override
    public void insert(TerapiaDTO dto) {
        Terapia t = new Terapia();
        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());
        terapiaRepository.save(t);
    }

    @Override
    public List<TerapiaDTO> list() {
        return terapiaRepository.findAll().stream().map(t -> {
            TerapiaDTO dto = new TerapiaDTO();
            dto.setIdTerapia(t.getIdTerapia());
            dto.setNombre(t.getNombre());
            dto.setDescripcion(t.getDescripcion());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        terapiaRepository.deleteById(id);
    }

    @Override
    public TerapiaDTO update(int id, TerapiaDTO dto) {
        Terapia t = terapiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Terapia no encontrada con ID: " + id));

        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());

        Terapia actualizada = terapiaRepository.save(t);

        TerapiaDTO result = new TerapiaDTO();
        result.setIdTerapia(actualizada.getIdTerapia());
        result.setNombre(actualizada.getNombre());
        result.setDescripcion(actualizada.getDescripcion());

        return result;
    }
}
