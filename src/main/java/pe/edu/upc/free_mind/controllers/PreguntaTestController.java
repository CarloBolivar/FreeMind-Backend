package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.PreguntaTestDTO;
import pe.edu.upc.free_mind.entities.PreguntaTest;
import pe.edu.upc.free_mind.servicesinterfaces.IPreguntaTestService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para la entidad PreguntaTest.
 * Expone endpoints para gestionar preguntas de test psicológico.
 */
@RestController
@RequestMapping("/preguntas")
public class PreguntaTestController {

    @Autowired
    private IPreguntaTestService preguntaTestService;

    /**
     * Lista todas las preguntas de test
     * @return Lista de PreguntaTestDTO
     */
    @GetMapping
    public List<PreguntaTestDTO> listar() {
        return preguntaTestService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PreguntaTestDTO.class);
        }).collect(Collectors.toList());
    }

    /**
     * Registra una nueva pregunta de test
     * @param dto DTO recibido del cliente
     */
    @PostMapping
    public void insertar(@RequestBody PreguntaTestDTO dto) {
        ModelMapper m = new ModelMapper();
        PreguntaTest p = m.map(dto, PreguntaTest.class);
        preguntaTestService.insert(p);
    }

    /**
     * Elimina una pregunta por su ID
     * @param id Identificador de la pregunta
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        preguntaTestService.delete(id);
    }

    /**
     * Obtiene una pregunta por ID
     * @param id ID buscado
     * @return DTO de la pregunta encontrada
     */
    @GetMapping("/{id}")
    public PreguntaTestDTO obtenerPorId(@PathVariable("id") Integer id) {
        PreguntaTest p = preguntaTestService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(p, PreguntaTestDTO.class);
    }

    /**
     * Modifica una pregunta existente
     * @param dto DTO con datos actualizados
     */
    @PutMapping
    public void modificar(@RequestBody PreguntaTestDTO dto) {
        ModelMapper m = new ModelMapper();
        PreguntaTest p = m.map(dto, PreguntaTest.class);
        preguntaTestService.update(p);
    }
}