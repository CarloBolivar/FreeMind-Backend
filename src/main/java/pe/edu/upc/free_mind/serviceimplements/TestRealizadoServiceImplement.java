package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.TestRealizadoDTO;
import pe.edu.upc.free_mind.entities.Test;
import pe.edu.upc.free_mind.entities.TestRealizado;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.repositories.ITestRealizadoRepository;
import pe.edu.upc.free_mind.repositories.ITestRepository;
import pe.edu.upc.free_mind.repositories.IUsuarioRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ITestRealizadoService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio para la entidad TestRealizado.
 */
@Service
public class TestRealizadoServiceImplement implements ITestRealizadoService {

    @Autowired
    private ITestRealizadoRepository testRealizadoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private ITestRepository testRepository;

    @Override
    public void insert(TestRealizadoDTO dto) {
        TestRealizado tr = new TestRealizado();
        tr.setFecha(dto.getFecha());
        tr.setPuntuacion(dto.getPuntuacion());

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario()).orElse(null);
        Test test = testRepository.findById(dto.getIdTest()).orElse(null);

        tr.setUsuario(usuario);
        tr.setTest(test);

        testRealizadoRepository.save(tr);
    }

    @Override
    public List<TestRealizadoDTO> list() {
        return testRealizadoRepository.findAll().stream().map(tr -> {
            TestRealizadoDTO dto = new TestRealizadoDTO();
            dto.setIdTestRealizado(tr.getIdTestRealizado());
            dto.setFecha(tr.getFecha());
            dto.setPuntuacion(tr.getPuntuacion());
            dto.setIdUsuario(tr.getUsuario().getIdUsuario());
            dto.setIdTest(tr.getTest().getIdTest());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        testRealizadoRepository.deleteById(id);
    }

    @Override
    public TestRealizadoDTO update(int id, TestRealizadoDTO dto) {
        TestRealizado tr = testRealizadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TestRealizado no encontrado con ID: " + id));

        tr.setFecha(dto.getFecha());
        tr.setPuntuacion(dto.getPuntuacion());

        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario()).orElse(null);
        Test test = testRepository.findById(dto.getIdTest()).orElse(null);

        tr.setUsuario(usuario);
        tr.setTest(test);

        TestRealizado actualizado = testRealizadoRepository.save(tr);

        TestRealizadoDTO result = new TestRealizadoDTO();
        result.setIdTestRealizado(actualizado.getIdTestRealizado());
        result.setFecha(actualizado.getFecha());
        result.setPuntuacion(actualizado.getPuntuacion());
        result.setIdUsuario(actualizado.getUsuario().getIdUsuario());
        result.setIdTest(actualizado.getTest().getIdTest());

        return result;
    }
}
