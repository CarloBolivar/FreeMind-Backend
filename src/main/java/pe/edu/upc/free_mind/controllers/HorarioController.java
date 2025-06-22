package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void insertar(@RequestBody HorarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Horario h = m.map(dto, Horario.class);
        Usuario u = usuarioService.listId(dto.getIdUsuario());
        h.setUsuario(u);
        h.setDisponible(dto.isDisponible());
        horarioService.insert(h);
    }

    @PutMapping
    public void modificar(@RequestBody HorarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Horario h = m.map(dto, Horario.class);
        Usuario u = usuarioService.listId(dto.getIdUsuario());
        h.setUsuario(u);
        h.setDisponible(dto.isDisponible());
        horarioService.update(h);
    }

    @GetMapping("/{id}")
    public HorarioDTO obtenerPorId(@PathVariable("id") Integer id) {
        Horario h = horarioService.listId(id);
        ModelMapper m = new ModelMapper();
        HorarioDTO dto = m.map(h, HorarioDTO.class);
        dto.setIdUsuario(h.getUsuario().getIdUsuario());
        dto.setDisponible(h.isDisponible());
        return dto;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        horarioService.delete(id);
    }

    // Lista horarios disponibles de un psicólogo específico
    @GetMapping("/disponibles/{idPsicologo}")
    public List<HorarioDTO> listarDisponiblesPorPsicologo(@PathVariable("idPsicologo") int idPsicologo) {
        return horarioService.list().stream()
                .filter(h -> h.isDisponible() && h.getUsuario().getIdUsuario() == idPsicologo)
                .map(h -> {
                    ModelMapper m = new ModelMapper();
                    HorarioDTO dto = m.map(h, HorarioDTO.class);
                    dto.setIdUsuario(h.getUsuario().getIdUsuario());
                    dto.setDisponible(h.isDisponible());
                    return dto;
                })
                .collect(Collectors.toList());
    }

}
