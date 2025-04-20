package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.HorarioDTO;
import pe.edu.upc.free_mind.servicesinterfaces.IHorarioService;

import java.util.List;

/**
 * Controlador REST para gestionar horarios disponibles.
 */
@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private IHorarioService horarioService;

    @PostMapping
    public void insert(@RequestBody HorarioDTO dto) {
        horarioService.insert(dto);
    }

    @GetMapping
    public List<HorarioDTO> list() {
        return horarioService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        horarioService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioDTO> update(@PathVariable("id") int id, @RequestBody HorarioDTO dto) {
        HorarioDTO actualizado = horarioService.update(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
