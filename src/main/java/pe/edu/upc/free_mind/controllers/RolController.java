package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.RolDTO;
import pe.edu.upc.free_mind.entities.Rol;
import pe.edu.upc.free_mind.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

//Controlador REST para la gestión de roles
@RestController
@RequestMapping("/roles")
public class RolController {

    //Servicio para operaciones sobre Rol
    @Autowired
    private IRolService rolService;

    //Lista todos los roles registrados
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<RolDTO> listar() {
        return rolService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    //Inserta un nuevo rol en la base de datos
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rolService.insert(r);
    }

    //Elimina un rol por ID
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rolService.delete(id);
    }

    //Obtiene un rol por su ID
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public RolDTO obtenerPorId(@PathVariable("id") Integer id) {
        Rol r = rolService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(r, RolDTO.class);
    }

    //Actualiza un rol existente
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rolService.update(r);
    }

    // Ruta pública para obtener solo PACIENTE y PSICOLOGO
    @GetMapping("/publicos")
    public List<RolDTO> listarPublicos() {
        return rolService.list().stream()
                .filter(r -> r.getNombre().equalsIgnoreCase("PACIENTE") || r.getNombre().equalsIgnoreCase("PSICOLOGO"))
                .map(r -> new ModelMapper().map(r, RolDTO.class))
                .collect(Collectors.toList());
    }
}
