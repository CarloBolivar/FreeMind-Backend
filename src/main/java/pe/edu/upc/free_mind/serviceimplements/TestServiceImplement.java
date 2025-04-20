package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.TestDTO;
import pe.edu.upc.free_mind.entities.Test;
import pe.edu.upc.free_mind.repositories.ITestRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ITestService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio para la entidad Test.
 */
@Service
public class TestServiceImplement implements ITestService {

    @Autowired
    private ITestRepository testRepository;

    @Override
    public void insert(TestDTO dto) {
        Test t = new Test();
        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());
        testRepository.save(t);
    }

    @Override
    public List<TestDTO> list() {
        return testRepository.findAll().stream().map(t -> {
            TestDTO dto = new TestDTO();
            dto.setIdTest(t.getIdTest());
            dto.setNombre(t.getNombre());
            dto.setDescripcion(t.getDescripcion());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        testRepository.deleteById(id);
    }

    @Override
    public TestDTO update(int id, TestDTO dto) {
        Test t = testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test no encontrado con ID: " + id));

        t.setNombre(dto.getNombre());
        t.setDescripcion(dto.getDescripcion());

        Test actualizado = testRepository.save(t);

        TestDTO result = new TestDTO();
        result.setIdTest(actualizado.getIdTest());
        result.setNombre(actualizado.getNombre());
        result.setDescripcion(actualizado.getDescripcion());

        return result;
    }
}
