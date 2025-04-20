package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.RespuestaTestDTO;
import pe.edu.upc.free_mind.entities.PreguntaTest;
import pe.edu.upc.free_mind.entities.RespuestaTest;
import pe.edu.upc.free_mind.repositories.IPreguntaTestRepository;
import pe.edu.upc.free_mind.repositories.IRespuestaTestRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IRespuestaTestService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio para la entidad RespuestaTest.
 */
@Service
public class RespuestaTestServiceImplement implements IRespuestaTestService {

    @Autowired
    private IRespuestaTestRepository respuestaTestRepository;

    @Autowired
    private IPreguntaTestRepository preguntaTestRepository;

    @Override
    public void insert(RespuestaTestDTO dto) {
        RespuestaTest r = new RespuestaTest();
        r.setContenido(dto.getContenido());
        r.setValor(dto.getValor());

        PreguntaTest p = preguntaTestRepository.findById(dto.getIdPregunta()).orElse(null);
        r.setPregunta(p);

        respuestaTestRepository.save(r);
    }

    @Override
    public List<RespuestaTestDTO> list() {
        return respuestaTestRepository.findAll().stream().map(r -> {
            RespuestaTestDTO dto = new RespuestaTestDTO();
            dto.setIdRespuesta(r.getIdRespuesta());
            dto.setContenido(r.getContenido());
            dto.setValor(r.getValor());
            dto.setIdPregunta(r.getPregunta().getIdPregunta());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        respuestaTestRepository.deleteById(id);
    }

    @Override
    public RespuestaTestDTO update(int id, RespuestaTestDTO dto) {
        RespuestaTest r = respuestaTestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada con ID: " + id));

        r.setContenido(dto.getContenido());
        r.setValor(dto.getValor());

        PreguntaTest p = preguntaTestRepository.findById(dto.getIdPregunta()).orElse(null);
        r.setPregunta(p);

        RespuestaTest actualizada = respuestaTestRepository.save(r);

        RespuestaTestDTO result = new RespuestaTestDTO();
        result.setIdRespuesta(actualizada.getIdRespuesta());
        result.setContenido(actualizada.getContenido());
        result.setValor(actualizada.getValor());
        result.setIdPregunta(actualizada.getPregunta().getIdPregunta());

        return result;
    }
}
