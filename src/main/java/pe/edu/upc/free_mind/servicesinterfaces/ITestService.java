package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.TestDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de tests psicológicos.
 */
public interface ITestService {
    void insert(TestDTO dto);
    List<TestDTO> list();
    void delete(int id);
    TestDTO update(int id, TestDTO dto);
}
