package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CantidadRecursosPorTerapiaDTO;
import pe.edu.upc.free_mind.dtos.RecursoDTO;
import pe.edu.upc.free_mind.entities.Recurso;
import pe.edu.upc.free_mind.servicesinterfaces.IRecursoService;

import java.util.List;
import java.util.stream.Collectors;

//Controlador REST para la gestión de recursos educativos
@RestController
@RequestMapping("/recursos")
public class RecursoController {

    //Servicio para operaciones sobre Recurso
    @Autowired
    private IRecursoService recursoService;

    //Lista todos los recursos registrados
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PACIENTE')")
    @GetMapping
    public List<RecursoDTO> listar() {
        return recursoService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecursoDTO.class);
        }).collect(Collectors.toList());
    }

    //Registra un nuevo recurso
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PACIENTE')")
    @PostMapping
    public void insertar(@RequestBody RecursoDTO dto) {
        ModelMapper m = new ModelMapper();
        Recurso r = m.map(dto, Recurso.class);
        recursoService.insert(r);
    }

    //Elimina un recurso por su ID
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PACIENTE')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        recursoService.delete(id);
    }

    //Obtiene un recurso por su ID
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PACIENTE')")
    @GetMapping("/{id}")
    public RecursoDTO obtenerPorId(@PathVariable("id") Integer id) {
        Recurso r = recursoService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(r, RecursoDTO.class);
    }

    //Modifica un recurso existente
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PACIENTE')")
    @PutMapping
    public void modificar(@RequestBody RecursoDTO dto) {
        ModelMapper m = new ModelMapper();
        Recurso r = m.map(dto, Recurso.class);
        recursoService.update(r);
    }

    //Reportes
    /*Mauricio*/
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PACIENTE')")
    @GetMapping("/cantidad-recursos-por-terapia")
    public List<CantidadRecursosPorTerapiaDTO> cantidadRecursosPorTerapia() {
        return recursoService.cantidadRecursosPorTerapia();
    }

}
