package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.PagoDTO;
import pe.edu.upc.free_mind.servicesinterfaces.IPagoService;

import java.util.List;

/**
 * Controlador REST para la gestión de pagos.
 */
@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private IPagoService pagoService;

    @PostMapping
    public void insert(@RequestBody PagoDTO dto) {
        pagoService.insert(dto);
    }

    @GetMapping
    public List<PagoDTO> list() {
        return pagoService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        pagoService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> update(@PathVariable("id") int id, @RequestBody PagoDTO dto) {
        PagoDTO actualizado = pagoService.update(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}
