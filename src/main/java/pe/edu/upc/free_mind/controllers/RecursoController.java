package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.RecursoDTO;
import pe.edu.upc.free_mind.servicesinterfaces.IRecursoService;

import java.util.List;

/**
 * Controlador REST para la gestión de recursos (multimedia) asociados a terapias.
 */
@RestController
@RequestMapping("/recursos")
public class RecursoController {

    @Autowired
    private IRecursoService recursoService;

    @PostMapping
    public void insert(@RequestBody RecursoDTO dto) {
        recursoService.insert(dto);
    }

    @GetMapping
    public List<RecursoDTO> list() {
        return recursoService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        recursoService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecursoDTO> update(@PathVariable("id") int id, @RequestBody RecursoDTO dto) {
        RecursoDTO actualizado = recursoService.update(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
