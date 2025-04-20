package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.TestDTO;
import pe.edu.upc.free_mind.servicesinterfaces.ITestService;

import java.util.List;

/**
 * Controlador REST para la gestión de tests psicológicos.
 */
@RestController
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private ITestService testService;

    @PostMapping
    public void insert(@RequestBody TestDTO dto) {
        testService.insert(dto);
    }

    @GetMapping
    public List<TestDTO> list() {
        return testService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        testService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestDTO> update(@PathVariable("id") int id, @RequestBody TestDTO dto) {
        TestDTO actualizado = testService.update(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
