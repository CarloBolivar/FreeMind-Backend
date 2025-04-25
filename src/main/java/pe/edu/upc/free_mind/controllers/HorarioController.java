package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.HorarioDTO;
import pe.edu.upc.free_mind.entities.Horario;
import pe.edu.upc.free_mind.servicesinterfaces.IHorarioService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para la entidad Horario.
 * Expone endpoints para gestionar los horarios disponibles.
 */
@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private IHorarioService horarioService;

    /**
     * Lista todos los horarios registrados
     * @return Lista de HorarioDTO
     */
    @GetMapping
    public List<HorarioDTO> listar() {
        return horarioService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, HorarioDTO.class);
        }).collect(Collectors.toList());
    }

    /**
     * Registra un nuevo horario
     * @param dto DTO recibido del cliente
     */
    @PostMapping
    public void insertar(@RequestBody HorarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Horario h = m.map(dto, Horario.class);
        horarioService.insert(h);
    }

    /**
     * Elimina un horario por su ID
     * @param id Identificador del horario
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        horarioService.delete(id);
    }

    /**
     * Obtiene un horario por su ID
     * @param id ID buscado
     * @return DTO del horario encontrado
     */
    @GetMapping("/{id}")
    public HorarioDTO obtenerPorId(@PathVariable("id") Integer id) {
        Horario h = horarioService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(h, HorarioDTO.class);
    }

    /**
     * Modifica un horario existente
     * @param dto Objeto con los datos actualizados
     */
    @PutMapping
    public void modificar(@RequestBody HorarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Horario h = m.map(dto, Horario.class);
        horarioService.update(h);
    }
}
