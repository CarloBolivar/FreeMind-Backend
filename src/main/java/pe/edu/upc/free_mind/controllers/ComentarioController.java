package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.ComentarioDTO;
import pe.edu.upc.free_mind.servicesinterfaces.IComentarioService;

import java.util.List;

/**
 * Controlador REST para la entidad Comentario.
 */
@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private IComentarioService comentarioService;

    @PostMapping
    public void insert(@RequestBody ComentarioDTO dto) {
        comentarioService.insert(dto);
    }

    @GetMapping
    public List<ComentarioDTO> list() {
        return comentarioService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        comentarioService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComentarioDTO> update(@PathVariable("id") int id, @RequestBody ComentarioDTO dto) {
        ComentarioDTO updated = comentarioService.update(id, dto);
        return ResponseEntity.ok(updated);
    }
}
