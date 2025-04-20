package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.TerapiaDTO;
import pe.edu.upc.free_mind.servicesinterfaces.ITerapiaService;

import java.util.List;

/**
 * Controlador REST para la gestión de terapias.
 */
@RestController
@RequestMapping("/terapias")
public class TerapiaController {

    @Autowired
    private ITerapiaService terapiaService;

    @PostMapping
    public void insert(@RequestBody TerapiaDTO dto) {
        terapiaService.insert(dto);
    }

    @GetMapping
    public List<TerapiaDTO> list() {
        return terapiaService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        terapiaService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TerapiaDTO> update(@PathVariable("id") int id, @RequestBody TerapiaDTO dto) {
        TerapiaDTO actualizado = terapiaService.update(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
