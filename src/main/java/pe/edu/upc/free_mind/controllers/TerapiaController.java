package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.TerapiaDTO;
import pe.edu.upc.free_mind.entities.Terapia;
import pe.edu.upc.free_mind.servicesinterfaces.ITerapiaService;

import java.util.List;
import java.util.stream.Collectors;

//Controlador REST para operaciones CRUD de terapias
@RestController
@RequestMapping("/terapias")
public class TerapiaController {

    //Servicio para operaciones sobre Terapia
    @Autowired
    private ITerapiaService terapiaService;

    //Lista todas las terapias registradas
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @GetMapping
    public List<TerapiaDTO> listar() {
        return terapiaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TerapiaDTO.class);
        }).collect(Collectors.toList());
    }

    //Inserta una nueva terapia
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @PostMapping
    public void insertar(@RequestBody TerapiaDTO dto) {
        ModelMapper m = new ModelMapper();
        Terapia t = m.map(dto, Terapia.class);
        terapiaService.insert(t);
    }

    //Elimina una terapia por su ID
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        terapiaService.delete(id);
    }

    //Obtiene una terapia específica por su ID
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @GetMapping("/{id}")
    public TerapiaDTO obtenerPorId(@PathVariable("id") Integer id) {
        Terapia t = terapiaService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(t, TerapiaDTO.class);
    }

    //Modifica una terapia existente
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @PutMapping
    public void modificar(@RequestBody TerapiaDTO dto) {
        ModelMapper m = new ModelMapper();
        Terapia t = m.map(dto, Terapia.class);
        terapiaService.update(t);
    }
}
