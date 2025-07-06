package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.TestDTO;
import pe.edu.upc.free_mind.entities.Test;
import pe.edu.upc.free_mind.servicesinterfaces.ITestService;

import java.util.List;
import java.util.stream.Collectors;

//Controlador REST para gestionar la creación y consulta de tests
@RestController
@RequestMapping("/tests")
public class TestController {

    //Servicio para operaciones sobre Test
    @Autowired
    private ITestService testService;

    //Lista todos los tests registrados
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @GetMapping
    public List<TestDTO> listar() {
        return testService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TestDTO.class);
        }).collect(Collectors.toList());
    }

    //Inserta un nuevo test en la base de datos
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @PostMapping
    public void insertar(@RequestBody TestDTO dto) {
        ModelMapper m = new ModelMapper();
        Test t = m.map(dto, Test.class);
        testService.insert(t);
    }

    //Elimina un test por su ID
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        testService.delete(id);
    }

    //Obtiene un test específico por su ID
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @GetMapping("/{id}")
    public TestDTO obtenerPorId(@PathVariable("id") Integer id) {
        Test t = testService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(t, TestDTO.class);
    }

    //Modifica un test existente
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @PutMapping
    public void modificar(@RequestBody TestDTO dto) {
        ModelMapper m = new ModelMapper();
        Test t = m.map(dto, Test.class);
        testService.update(t);
    }

}
