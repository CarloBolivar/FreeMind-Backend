package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.TestDTO;
import pe.edu.upc.free_mind.entities.Test;
import pe.edu.upc.free_mind.servicesinterfaces.ITestService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para la entidad Test.
 * Expone endpoints para gestionar la creación y consulta de tests.
 */
@RestController
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private ITestService testService;

    /**
     * Lista todos los tests registrados
     * @return Lista de TestDTO
     */
    @GetMapping
    public List<TestDTO> listar() {
        return testService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TestDTO.class);
        }).collect(Collectors.toList());
    }

    /**
     * Inserta un nuevo test en la base de datos
     * @param dto DTO del test recibido
     */
    @PostMapping
    public void insertar(@RequestBody TestDTO dto) {
        ModelMapper m = new ModelMapper();
        Test t = m.map(dto, Test.class);
        testService.insert(t);
    }

    /**
     * Elimina un test por su ID
     * @param id ID del test a eliminar
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        testService.delete(id);
    }

    /**
     * Obtiene un test específico por ID
     * @param id ID buscado
     * @return Objeto TestDTO correspondiente
     */
    @GetMapping("/{id}")
    public TestDTO obtenerPorId(@PathVariable("id") Integer id) {
        Test t = testService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(t, TestDTO.class);
    }

    /**
     * Modifica un test existente
     * @param dto DTO actualizado
     */
    @PutMapping
    public void modificar(@RequestBody TestDTO dto) {
        ModelMapper m = new ModelMapper();
        Test t = m.map(dto, Test.class);
        testService.update(t);
    }
}
