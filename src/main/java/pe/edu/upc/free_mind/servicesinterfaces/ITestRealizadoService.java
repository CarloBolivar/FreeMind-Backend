package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.dtos.TestRealizadoDTO;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de tests realizados por usuarios.
 */
public interface ITestRealizadoService {
    void insert(TestRealizadoDTO dto);
    List<TestRealizadoDTO> list();
    void delete(int id);
    TestRealizadoDTO update(int id, TestRealizadoDTO dto);
}
