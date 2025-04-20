package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.UsuarioDTO;
import pe.edu.upc.free_mind.servicesinterfaces.IUsuarioService;

import java.util.List;

/**
 * Controlador REST para la entidad Usuario.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping
    public void insert(@RequestBody UsuarioDTO dto) {
        usuarioService.insert(dto);
    }

    @GetMapping
    public List<UsuarioDTO> list() {
        return usuarioService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        usuarioService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable("id") int id, @RequestBody UsuarioDTO dto) {
        UsuarioDTO updated = usuarioService.update(id, dto);
        return ResponseEntity.ok(updated);
    }
}
