package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CitaDTO;
import pe.edu.upc.free_mind.entities.Cita;
import pe.edu.upc.free_mind.servicesinterfaces.ICitaService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para la entidad Cita.
 * Expone endpoints para gestionar citas entre usuarios.
 */
@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    /**
     * Lista todas las citas existentes
     * @return Lista de CitaDTO
     */
    @GetMapping
    public List<CitaDTO> listar() {
        return citaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CitaDTO.class);
        }).collect(Collectors.toList());
    }

    /**
     * Registra una nueva cita
     * @param dto Objeto DTO recibido del cliente
     */
    @PostMapping
    public void insertar(@RequestBody CitaDTO dto) {
        ModelMapper m = new ModelMapper();
        Cita c = m.map(dto, Cita.class);
        citaService.insert(c);
    }

    /**
     * Elimina una cita por su ID
     * @param id Identificador de la cita
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        citaService.delete(id);
    }

    /**
     * Obtiene una cita por ID
     * @param id ID buscado
     * @return Objeto DTO de la cita encontrada
     */
    @GetMapping("/{id}")
    public CitaDTO obtenerPorId(@PathVariable("id") Integer id) {
        Cita c = citaService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(c, CitaDTO.class);
    }

    /**
     * Modifica una cita existente
     * @param dto Objeto con los datos actualizados
     */
    @PutMapping
    public void modificar(@RequestBody CitaDTO dto) {
        ModelMapper m = new ModelMapper();
        Cita c = m.map(dto, Cita.class);
        citaService.update(c);
    }

    /**
     * Obtiene la cantidad de citas atendidas por cada psicólogo
     * @return Lista de objetos CantidadCitasPorPsicologoDTO
     */
    @GetMapping("/cantidad-citas-por-psicologo")
    public List<String[]> obtenerCantidadCitasPorPsicologo() {
        return citaService.obtenerCantidadCitasPorPsicologo();
    }
}
