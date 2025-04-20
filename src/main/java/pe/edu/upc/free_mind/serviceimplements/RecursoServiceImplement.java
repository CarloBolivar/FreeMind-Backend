package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.RecursoDTO;
import pe.edu.upc.free_mind.entities.Recurso;
import pe.edu.upc.free_mind.entities.Terapia;
import pe.edu.upc.free_mind.repositories.IRecursoRepository;
import pe.edu.upc.free_mind.repositories.ITerapiaRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IRecursoService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio para la entidad Recurso.
 */
@Service
public class RecursoServiceImplement implements IRecursoService {

    @Autowired
    private IRecursoRepository recursoRepository;

    @Autowired
    private ITerapiaRepository terapiaRepository;

    @Override
    public void insert(RecursoDTO dto) {
        Recurso r = new Recurso();
        r.setTipo(dto.getTipo());
        r.setUrl(dto.getUrl());

        Terapia terapia = terapiaRepository.findById(dto.getIdTerapia()).orElse(null);
        r.setTerapia(terapia);

        recursoRepository.save(r);
    }

    @Override
    public List<RecursoDTO> list() {
        return recursoRepository.findAll().stream().map(r -> {
            RecursoDTO dto = new RecursoDTO();
            dto.setIdRecurso(r.getIdRecurso());
            dto.setTipo(r.getTipo());
            dto.setUrl(r.getUrl());
            dto.setIdTerapia(r.getTerapia().getIdTerapia());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        recursoRepository.deleteById(id);
    }

    @Override
    public RecursoDTO update(int id, RecursoDTO dto) {
        Recurso r = recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso no encontrado con ID: " + id));

        r.setTipo(dto.getTipo());
        r.setUrl(dto.getUrl());

        Terapia terapia = terapiaRepository.findById(dto.getIdTerapia()).orElse(null);
        r.setTerapia(terapia);

        Recurso actualizado = recursoRepository.save(r);

        RecursoDTO result = new RecursoDTO();
        result.setIdRecurso(actualizado.getIdRecurso());
        result.setTipo(actualizado.getTipo());
        result.setUrl(actualizado.getUrl());
        result.setIdTerapia(actualizado.getTerapia().getIdTerapia());

        return result;
    }
}
