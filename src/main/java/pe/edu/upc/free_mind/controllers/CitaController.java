package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CitaDTO;
import pe.edu.upc.free_mind.servicesinterfaces.ICitaService;

import java.util.List;

/**
 * Controlador REST para la gestión de citas.
 */
@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    @PostMapping
    public void insert(@RequestBody CitaDTO dto) {
        citaService.insert(dto);
    }

    @GetMapping
    public List<CitaDTO> list() {
        return citaService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        citaService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaDTO> update(@PathVariable("id") int id, @RequestBody CitaDTO dto) {
        CitaDTO actualizado = citaService.update(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
