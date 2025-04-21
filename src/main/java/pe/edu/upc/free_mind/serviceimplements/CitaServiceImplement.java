package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.CitaDTO;
import pe.edu.upc.free_mind.entities.Cita;
import pe.edu.upc.free_mind.entities.Horario;
import pe.edu.upc.free_mind.entities.Terapia;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.repositories.ICitaRepository;
import pe.edu.upc.free_mind.repositories.IHorarioRepository;
import pe.edu.upc.free_mind.repositories.ITerapiaRepository;
import pe.edu.upc.free_mind.repositories.IUsuarioRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ICitaService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación de servicio para la entidad Cita.
 */
@Service
public class CitaServiceImplement implements ICitaService {

    @Autowired
    private ICitaRepository citaRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IHorarioRepository horarioRepository;

    @Autowired
    private ITerapiaRepository terapiaRepository;

    @Override
    public void insert(CitaDTO dto) {
        Cita c = new Cita();
        c.setFecha(dto.getFecha());
        c.setHora(dto.getHora());

        Usuario paciente = usuarioRepository.findById(dto.getIdPaciente()).orElse(null);
        Usuario psicologo = usuarioRepository.findById(dto.getIdPsicologo()).orElse(null);
        Horario horario = horarioRepository.findById(dto.getIdHorario()).orElse(null);
        Terapia terapia = terapiaRepository.findById(dto.getIdTerapia()).orElse(null);
        c.setPaciente(paciente);
        c.setPsicologo(psicologo);
        c.setHorario(horario);
        c.setTerapia(terapia);

        citaRepository.save(c);
    }

    @Override
    public List<CitaDTO> list() {
        return citaRepository.findAll().stream().map(c -> {
            CitaDTO dto = new CitaDTO();
            dto.setIdCita(c.getIdCita());
            dto.setFecha(c.getFecha());
            dto.setHora(c.getHora());
            dto.setIdPaciente(c.getPaciente().getIdUsuario());
            dto.setIdPsicologo(c.getPsicologo().getIdUsuario());
            dto.setIdHorario(c.getHorario().getIdHorario());
            dto.setIdTerapia(c.getTerapia().getIdTerapia());

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        citaRepository.deleteById(id);
    }

    @Override
    public CitaDTO update(int id, CitaDTO dto) {
        Cita c = citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));

        c.setFecha(dto.getFecha());
        c.setHora(dto.getHora());

        Usuario paciente = usuarioRepository.findById(dto.getIdPaciente()).orElse(null);
        Usuario psicologo = usuarioRepository.findById(dto.getIdPsicologo()).orElse(null);
        Horario horario = horarioRepository.findById(dto.getIdHorario()).orElse(null);
        Terapia terapia = terapiaRepository.findById(dto.getIdTerapia()).orElse(null);
        c.setPaciente(paciente);
        c.setPsicologo(psicologo);
        c.setHorario(horario);
        c.setTerapia(terapia);

        Cita actualizada = citaRepository.save(c);

        CitaDTO result = new CitaDTO();
        result.setIdCita(actualizada.getIdCita());
        result.setFecha(actualizada.getFecha());
        result.setHora(actualizada.getHora());
        result.setIdPaciente(actualizada.getPaciente().getIdUsuario());
        result.setIdPsicologo(actualizada.getPsicologo().getIdUsuario());
        result.setIdHorario(actualizada.getHorario().getIdHorario());
        result.setIdTerapia(actualizada.getTerapia().getIdTerapia());
        return result;
    }
}
