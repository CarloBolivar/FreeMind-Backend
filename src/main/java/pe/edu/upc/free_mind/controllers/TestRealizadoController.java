package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.TestRealizadoDTO;
import pe.edu.upc.free_mind.entities.TestRealizado;
import pe.edu.upc.free_mind.servicesinterfaces.ITestRealizadoService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para la entidad TestRealizado.
 * Expone endpoints para gestionar tests realizados por usuarios.
 */
@RestController
@RequestMapping("/tests-realizados")
public class TestRealizadoController {

    @Autowired
    private ITestRealizadoService testRealizadoService;

    /**
     * Lista todos los tests realizados
     * @return Lista de TestRealizadoDTO
     */
    @GetMapping
    public List<TestRealizadoDTO> listar() {
        return testRealizadoService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TestRealizadoDTO.class);
        }).collect(Collectors.toList());
    }

    /**
     * Registra un nuevo test realizado
     * @param dto DTO recibido del cliente
     */
    @PostMapping
    public void insertar(@RequestBody TestRealizadoDTO dto) {
        ModelMapper m = new ModelMapper();
        TestRealizado t = m.map(dto, TestRealizado.class);
        testRealizadoService.insert(t);
    }

    /**
     * Elimina un test realizado por su ID
     * @param id Identificador del test
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        testRealizadoService.delete(id);
    }

    /**
     * Obtiene un test realizado por ID
     * @param id ID buscado
     * @return DTO del test encontrado
     */
    @GetMapping("/{id}")
    public TestRealizadoDTO obtenerPorId(@PathVariable("id") Integer id) {
        TestRealizado t = testRealizadoService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(t, TestRealizadoDTO.class);
    }

    /**
     * Modifica un test realizado existente
     * @param dto Objeto con los datos actualizados
     */
    @PutMapping
    public void modificar(@RequestBody TestRealizadoDTO dto) {
        ModelMapper m = new ModelMapper();
        TestRealizado t = m.map(dto, TestRealizado.class);
        testRealizadoService.update(t);
    }
}
