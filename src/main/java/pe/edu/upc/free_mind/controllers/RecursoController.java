package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.RecursoDTO;
import pe.edu.upc.free_mind.entities.Recurso;
import pe.edu.upc.free_mind.servicesinterfaces.IRecursoService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para la entidad Recurso.
 * Expone endpoints para gestionar recursos educativos.
 */
@RestController
@RequestMapping("/recursos")
public class RecursoController {

    @Autowired
    private IRecursoService recursoService;

    /**
     * Lista todos los recursos
     * @return Lista de RecursoDTO
     */
    @GetMapping
    public List<RecursoDTO> listar() {
        return recursoService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecursoDTO.class);
        }).collect(Collectors.toList());
    }

    /**
     * Registra un nuevo recurso
     * @param dto DTO recibido del cliente
     */
    @PostMapping
    public void insertar(@RequestBody RecursoDTO dto) {
        ModelMapper m = new ModelMapper();
        Recurso r = m.map(dto, Recurso.class);
        recursoService.insert(r);
    }

    /**
     * Elimina un recurso por su ID
     * @param id Identificador del recurso
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        recursoService.delete(id);
    }

    /**
     * Obtiene un recurso por ID
     * @param id ID buscado
     * @return DTO del recurso encontrado
     */
    @GetMapping("/{id}")
    public RecursoDTO obtenerPorId(@PathVariable("id") Integer id) {
        Recurso r = recursoService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(r, RecursoDTO.class);
    }

    /**
     * Modifica un recurso existente
     * @param dto Objeto con los datos actualizados
     */
    @PutMapping
    public void modificar(@RequestBody RecursoDTO dto) {
        ModelMapper m = new ModelMapper();
        Recurso r = m.map(dto, Recurso.class);
        recursoService.update(r);
    }
}
