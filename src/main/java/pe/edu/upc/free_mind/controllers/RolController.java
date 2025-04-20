package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.RolDTO;
import pe.edu.upc.free_mind.servicesinterfaces.IRolService;

import java.util.List;

/**
 * Controlador REST que maneja las operaciones CRUD de los roles.
 */
@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rolService;

    /**
     * Inserta un nuevo rol.
     */
    @PostMapping
    public void insert(@RequestBody RolDTO dto) {
        rolService.insert(dto);
    }

    /**
     * Lista todos los roles existentes.
     */
    @GetMapping
    public List<RolDTO> list() {
        return rolService.list();
    }

    /**
     * Elimina un rol por su ID.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        rolService.delete(id);
    }

    /**
     * Actualiza los datos de un rol existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> update(@PathVariable("id") int id, @RequestBody RolDTO dto) {
        RolDTO actualizado = rolService.update(id, dto);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
