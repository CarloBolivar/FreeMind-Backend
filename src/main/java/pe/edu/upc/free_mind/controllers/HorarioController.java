package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.HorarioDTO;
import pe.edu.upc.free_mind.entities.Horario;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.servicesinterfaces.IHorarioService;
import pe.edu.upc.free_mind.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private IHorarioService horarioService;

    @Autowired
    private IUsuarioService usuarioService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @GetMapping
    public List<HorarioDTO> listar() {
        return horarioService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            HorarioDTO dto = m.map(x, HorarioDTO.class);
            dto.setIdUsuario(x.getUsuario().getIdUsuario());
            dto.setDisponible(x.isDisponible());
            dto.setNombreUsuario(x.getUsuario().getNombre());
            return dto;
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @PostMapping
    public void insertar(@RequestBody HorarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Horario h = m.map(dto, Horario.class);
        Usuario u = usuarioService.listId(dto.getIdUsuario());
        h.setUsuario(u);
        h.setDisponible(dto.isDisponible());
        horarioService.insert(h);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @PutMapping
    public void modificar(@RequestBody HorarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Horario h = m.map(dto, Horario.class);
        Usuario u = usuarioService.listId(dto.getIdUsuario());
        h.setUsuario(u);
        h.setDisponible(dto.isDisponible());
        horarioService.update(h);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @GetMapping("/{id}")
    public HorarioDTO obtenerPorId(@PathVariable("id") Integer id) {
        Horario h = horarioService.listId(id);
        ModelMapper m = new ModelMapper();
        HorarioDTO dto = m.map(h, HorarioDTO.class);
        dto.setIdUsuario(h.getUsuario().getIdUsuario());
        dto.setDisponible(h.isDisponible());
        return dto;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        horarioService.delete(id);
    }

    //Reportes

    // Lista horarios disponibles de un psicólogo específico
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PACIENTE')")
    @GetMapping("/disponibles")
    public List<HorarioDTO> listarTodosLosDisponibles() {
        return horarioService.list().stream()
                .filter(Horario::isDisponible)
                .map(h -> {
                    ModelMapper m = new ModelMapper();
                    HorarioDTO dto = m.map(h, HorarioDTO.class);
                    dto.setIdUsuario(h.getUsuario().getIdUsuario());
                    dto.setDisponible(h.isDisponible());
                    dto.setNombreUsuario(h.getUsuario().getNombre());
                    return dto;
                })
                .collect(Collectors.toList());
    }

}
