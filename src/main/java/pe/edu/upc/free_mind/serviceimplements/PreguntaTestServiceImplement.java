package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.PreguntaTestDTO;
import pe.edu.upc.free_mind.entities.PreguntaTest;
import pe.edu.upc.free_mind.entities.Test;
import pe.edu.upc.free_mind.repositories.IPreguntaTestRepository;
import pe.edu.upc.free_mind.repositories.ITestRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IPreguntaTestService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio para la entidad PreguntaTest.
 */
@Service
public class PreguntaTestServiceImplement implements IPreguntaTestService {

    @Autowired
    private IPreguntaTestRepository preguntaTestRepository;

    @Autowired
    private ITestRepository testRepository;

    @Override
    public void insert(PreguntaTestDTO dto) {
        PreguntaTest p = new PreguntaTest();
        p.setContenido(dto.getContenido());

        Test test = testRepository.findById(dto.getIdTest()).orElse(null);
        p.setTest(test);

        preguntaTestRepository.save(p);
    }

    @Override
    public List<PreguntaTestDTO> list() {
        return preguntaTestRepository.findAll().stream().map(p -> {
            PreguntaTestDTO dto = new PreguntaTestDTO();
            dto.setIdPregunta(p.getIdPregunta());
            dto.setContenido(p.getContenido());
            dto.setIdTest(p.getTest().getIdTest());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        preguntaTestRepository.deleteById(id);
    }

    @Override
    public PreguntaTestDTO update(int id, PreguntaTestDTO dto) {
        PreguntaTest p = preguntaTestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada con ID: " + id));

        p.setContenido(dto.getContenido());
        Test test = testRepository.findById(dto.getIdTest()).orElse(null);
        p.setTest(test);

        PreguntaTest actualizada = preguntaTestRepository.save(p);

        PreguntaTestDTO result = new PreguntaTestDTO();
        result.setIdPregunta(actualizada.getIdPregunta());
        result.setContenido(actualizada.getContenido());
        result.setIdTest(actualizada.getTest().getIdTest());

        return result;
    }
}
