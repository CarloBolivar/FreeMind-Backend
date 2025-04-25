package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.RolDTO;
import pe.edu.upc.free_mind.entities.Rol;
import pe.edu.upc.free_mind.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para la gestión de roles.
 * Expone endpoints REST y realiza mapeo entre entidades y DTOs.
 */
@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rolService;

    /**
     * Lista todos los roles registrados.
     * @return Lista de RolDTO
     */
    @GetMapping
    public List<RolDTO> listar() {
        return rolService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    /**
     * Inserta un nuevo rol en la base de datos.
     * @param dto Objeto RolDTO recibido desde el cliente
     */
    @PostMapping
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rolService.insert(r);
    }

    /**
     * Elimina un rol por ID
     * @param id ID del rol a eliminar
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rolService.delete(id);
    }

    /**
     * Obtiene un rol por su ID
     * @param id ID del rol a consultar
     * @return DTO del rol encontrado
     */
    @GetMapping("/{id}")
    public RolDTO obtenerPorId(@PathVariable("id") Integer id) {
        Rol r = rolService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(r, RolDTO.class);
    }

    /**
     * Actualiza un rol existente
     * @param dto DTO con los nuevos datos del rol
     */
    @PutMapping
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rolService.update(r);
    }
}