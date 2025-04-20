package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.RespuestaTestDTO;
import pe.edu.upc.free_mind.servicesinterfaces.IRespuestaTestService;

import java.util.List;

/**
 * Controlador REST para la gestión de respuestas asociadas a preguntas de test.
 */
@RestController
@RequestMapping("/respuestas")
public class RespuestaTestController {

    @Autowired
    private IRespuestaTestService respuestaTestService;

    @PostMapping
    public void insert(@RequestBody RespuestaTestDTO dto) {
        respuestaTestService.insert(dto);
    }

    @GetMapping
    public List<RespuestaTestDTO> list() {
        return respuestaTestService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        respuestaTestService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaTestDTO> update(@PathVariable("id") int id, @RequestBody RespuestaTestDTO dto) {
        RespuestaTestDTO actualizado = respuestaTestService.update(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
