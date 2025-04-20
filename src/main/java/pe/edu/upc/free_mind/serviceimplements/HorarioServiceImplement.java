package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.HorarioDTO;
import pe.edu.upc.free_mind.entities.Horario;
import pe.edu.upc.free_mind.repositories.IHorarioRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IHorarioService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación de la interfaz de servicio para la entidad Horario.
 */
@Service
public class HorarioServiceImplement implements IHorarioService {

    @Autowired
    private IHorarioRepository horarioRepository;

    @Override
    public void insert(HorarioDTO dto) {
        Horario h = new Horario();
        h.setDia(dto.getDia());
        h.setHoraInicio(dto.getHoraInicio());
        h.setHoraFin(dto.getHoraFin());
        horarioRepository.save(h);
    }

    @Override
    public List<HorarioDTO> list() {
        return horarioRepository.findAll().stream().map(h -> {
            HorarioDTO dto = new HorarioDTO();
            dto.setIdHorario(h.getIdHorario());
            dto.setDia(h.getDia());
            dto.setHoraInicio(h.getHoraInicio());
            dto.setHoraFin(h.getHoraFin());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        horarioRepository.deleteById(id);
    }

    @Override
    public HorarioDTO update(int id, HorarioDTO dto) {
        Horario h = horarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));

        h.setDia(dto.getDia());
        h.setHoraInicio(dto.getHoraInicio());
        h.setHoraFin(dto.getHoraFin());

        Horario actualizado = horarioRepository.save(h);

        HorarioDTO result = new HorarioDTO();
        result.setIdHorario(actualizado.getIdHorario());
        result.setDia(actualizado.getDia());
        result.setHoraInicio(actualizado.getHoraInicio());
        result.setHoraFin(actualizado.getHoraFin());

        return result;
    }
}
