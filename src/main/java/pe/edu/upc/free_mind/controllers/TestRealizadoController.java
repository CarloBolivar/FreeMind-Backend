package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.TestRealizadoDTO;
import pe.edu.upc.free_mind.servicesinterfaces.ITestRealizadoService;

import java.util.List;

/**
 * Controlador REST para la gestión de tests realizados.
 */
@RestController
@RequestMapping("/testsrealizados")
public class TestRealizadoController {

    @Autowired
    private ITestRealizadoService testRealizadoService;

    @PostMapping
    public void insert(@RequestBody TestRealizadoDTO dto) {
        testRealizadoService.insert(dto);
    }

    @GetMapping
    public List<TestRealizadoDTO> list() {
        return testRealizadoService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        testRealizadoService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestRealizadoDTO> update(@PathVariable("id") int id, @RequestBody TestRealizadoDTO dto) {
        TestRealizadoDTO actualizado = testRealizadoService.update(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
