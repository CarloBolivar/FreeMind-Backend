package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CantidadCitasPorTerapiaDTO;
import pe.edu.upc.free_mind.dtos.CantidadTotalIngresosPorPsicologoDTO;
import pe.edu.upc.free_mind.dtos.CitaDTO;
import pe.edu.upc.free_mind.entities.Cita;
import pe.edu.upc.free_mind.entities.Horario;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.entities.Terapia;
import pe.edu.upc.free_mind.servicesinterfaces.ICitaService;
import pe.edu.upc.free_mind.servicesinterfaces.IHorarioService;
import pe.edu.upc.free_mind.servicesinterfaces.IUsuarioService;
import pe.edu.upc.free_mind.servicesinterfaces.ITerapiaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    @Autowired
    private IHorarioService horarioService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ITerapiaService terapiaService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @GetMapping
    public List<CitaDTO> listar() {
        return citaService.list().stream().map(c -> {
            CitaDTO dto = new CitaDTO();
            dto.setIdCita(c.getIdCita());
            dto.setEstado(c.getEstado());
            dto.setIdHorario(c.getHorario().getIdHorario());
            dto.setIdPaciente(c.getPaciente().getIdUsuario());
            dto.setIdPsicologo(c.getPsicologo().getIdUsuario());
            dto.setIdTerapia(c.getTerapia() != null ? c.getTerapia().getIdTerapia() : null);
            return dto;
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @PostMapping
    public void insertar(@RequestBody CitaDTO dto) {
        Cita c = new Cita();
        c.setEstado(dto.getEstado());

        // Relaciones
        Horario horario = horarioService.listId(dto.getIdHorario());
        Usuario paciente = usuarioService.listId(dto.getIdPaciente());
        Usuario psicologo = usuarioService.listId(dto.getIdPsicologo());
        Terapia terapia = (dto.getIdTerapia() != null) ? terapiaService.listId(dto.getIdTerapia()) : null;

        c.setHorario(horario);
        c.setPaciente(paciente);
        c.setPsicologo(psicologo);
        c.setTerapia(terapia);

        citaService.insert(c);

        // Marcar horario como no disponible
        horario.setDisponible(false);
        horarioService.update(horario);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @PutMapping
    public void modificar(@RequestBody CitaDTO dto) {
        Cita c = citaService.listId(dto.getIdCita());
        int idHorarioAnterior = c.getHorario().getIdHorario();

        // Actualizar datos
        c.setEstado(dto.getEstado());
        Horario nuevoHorario = horarioService.listId(dto.getIdHorario());
        Usuario paciente = usuarioService.listId(dto.getIdPaciente());
        Usuario psicologo = usuarioService.listId(dto.getIdPsicologo());
        Terapia terapia = (dto.getIdTerapia() != null) ? terapiaService.listId(dto.getIdTerapia()) : null;

        c.setHorario(nuevoHorario);
        c.setPaciente(paciente);
        c.setPsicologo(psicologo);
        c.setTerapia(terapia);

        citaService.update(c);

        // Si cambió el horario, liberar el anterior y ocupar el nuevo
        if (idHorarioAnterior != nuevoHorario.getIdHorario()) {
            Horario anterior = horarioService.listId(idHorarioAnterior);
            anterior.setDisponible(true);
            horarioService.update(anterior);

            nuevoHorario.setDisponible(false);
            horarioService.update(nuevoHorario);
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @GetMapping("/{id}")
    public CitaDTO obtenerPorId(@PathVariable("id") Integer id) {
        Cita c = citaService.listId(id);
        CitaDTO dto = new CitaDTO();
        dto.setIdCita(c.getIdCita());
        dto.setEstado(c.getEstado());
        dto.setIdHorario(c.getHorario().getIdHorario());
        dto.setIdPaciente(c.getPaciente().getIdUsuario());
        dto.setIdPsicologo(c.getPsicologo().getIdUsuario());
        dto.setIdTerapia(c.getTerapia() != null ? c.getTerapia().getIdTerapia() : null);
        return dto;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        citaService.delete(id);
    }

    //Reportes - Deyci
    //Obtiene la cantidad de citas por tipo de terapias
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @GetMapping("/cantidadCitasPorTerapia")
    public List<CantidadCitasPorTerapiaDTO> obtenerCantidadCitasPorTerapia() {
        List<CantidadCitasPorTerapiaDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = citaService.obtenerCantidadCitasPorTerapia();
        for (String[] columna : fila) {
            CantidadCitasPorTerapiaDTO dto = new CantidadCitasPorTerapiaDTO();
            dto.setNameTerapia(columna[0]);
            dto.setDescripcion(columna[1]);
            dto.setQuantityCitas(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    //Obtiene el total de ingresos por psicólogo
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO')")
    @GetMapping("/totalIngresosPsicologos")
    public List<CantidadTotalIngresosPorPsicologoDTO> obtenerTotalIngresosPorPsicologo() {
        List<CantidadTotalIngresosPorPsicologoDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = citaService.totalIngresosPorPsicologo();
        for (String[] columna : fila) {
            CantidadTotalIngresosPorPsicologoDTO dto = new CantidadTotalIngresosPorPsicologoDTO();
            dto.setNombre(columna[0]);
            dto.setApellido(columna[1]);
            dto.setTotalIngresos(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
            return dtoLista;
        }
}
