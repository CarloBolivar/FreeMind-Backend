package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.PreguntaTestDTO;
import pe.edu.upc.free_mind.entities.PreguntaTest;
import pe.edu.upc.free_mind.servicesinterfaces.IPreguntaTestService;

import java.util.List;
import java.util.stream.Collectors;

//Controlador REST para gestionar preguntas de test psicológico
@RestController
@RequestMapping("/preguntas")
public class PreguntaTestController {

    //Servicio para operaciones sobre PreguntaTest
    @Autowired
    private IPreguntaTestService preguntaTestService;

    //Lista todas las preguntas de test
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @GetMapping
    public List<PreguntaTestDTO> listar() {
        return preguntaTestService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PreguntaTestDTO.class);
        }).collect(Collectors.toList());
    }

    //Registra una nueva pregunta de test
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @PostMapping
    public void insertar(@RequestBody PreguntaTestDTO dto) {
        ModelMapper m = new ModelMapper();
        PreguntaTest p = m.map(dto, PreguntaTest.class);
        preguntaTestService.insert(p);
    }

    //Elimina una pregunta por su ID
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        preguntaTestService.delete(id);
    }

    //Obtiene una pregunta por su ID
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @GetMapping("/{id}")
    public PreguntaTestDTO obtenerPorId(@PathVariable("id") Integer id) {
        PreguntaTest p = preguntaTestService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(p, PreguntaTestDTO.class);
    }

    //Modifica una pregunta existente
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @PutMapping
    public void modificar(@RequestBody PreguntaTestDTO dto) {
        ModelMapper m = new ModelMapper();
        PreguntaTest p = m.map(dto, PreguntaTest.class);
        preguntaTestService.update(p);
    }
}
