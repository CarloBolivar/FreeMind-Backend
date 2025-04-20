package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.PreguntaTestDTO;
import pe.edu.upc.free_mind.servicesinterfaces.IPreguntaTestService;

import java.util.List;

/**
 * Controlador REST para la gestión de preguntas de test.
 */
@RestController
@RequestMapping("/preguntas")
public class PreguntaTestController {

    @Autowired
    private IPreguntaTestService preguntaTestService;

    @PostMapping
    public void insert(@RequestBody PreguntaTestDTO dto) {
        preguntaTestService.insert(dto);
    }

    @GetMapping
    public List<PreguntaTestDTO> list() {
        return preguntaTestService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        preguntaTestService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreguntaTestDTO> update(@PathVariable("id") int id, @RequestBody PreguntaTestDTO dto) {
        PreguntaTestDTO actualizado = preguntaTestService.update(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
