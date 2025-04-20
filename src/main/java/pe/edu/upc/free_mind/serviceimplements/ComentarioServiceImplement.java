package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.ComentarioDTO;
import pe.edu.upc.free_mind.entities.Comentario;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.repositories.IComentarioRepository;
import pe.edu.upc.free_mind.repositories.IUsuarioRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IComentarioService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio para la entidad Comentario.
 */
@Service
public class ComentarioServiceImplement implements IComentarioService {

    @Autowired
    private IComentarioRepository comentarioRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public void insert(ComentarioDTO dto) {
        Comentario c = new Comentario();
        c.setComentario(dto.getComentario());
        c.setPuntuacion(dto.getPuntuacion());
        c.setFecha(dto.getFecha());

        Usuario paciente = usuarioRepository.findById(dto.getIdPaciente()).orElse(null);
        Usuario psicologo = usuarioRepository.findById(dto.getIdPsicologo()).orElse(null);

        c.setPaciente(paciente);
        c.setPsicologo(psicologo);

        comentarioRepository.save(c);
    }

    @Override
    public List<ComentarioDTO> list() {
        return comentarioRepository.findAll().stream().map(c -> {
            ComentarioDTO dto = new ComentarioDTO();
            dto.setIdComentario(c.getIdComentario());
            dto.setComentario(c.getComentario());
            dto.setPuntuacion(c.getPuntuacion());
            dto.setFecha(c.getFecha());
            dto.setIdPaciente(c.getPaciente().getIdUsuario());
            dto.setIdPsicologo(c.getPsicologo().getIdUsuario());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public ComentarioDTO update(int id, ComentarioDTO dto) {
        Comentario c = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado con id: " + id));

        c.setComentario(dto.getComentario());
        c.setPuntuacion(dto.getPuntuacion());
        c.setFecha(dto.getFecha());

        Usuario paciente = usuarioRepository.findById(dto.getIdPaciente()).orElse(null);
        Usuario psicologo = usuarioRepository.findById(dto.getIdPsicologo()).orElse(null);

        c.setPaciente(paciente);
        c.setPsicologo(psicologo);

        comentarioRepository.save(c);

        ComentarioDTO result = new ComentarioDTO();
        result.setIdComentario(c.getIdComentario());
        result.setComentario(c.getComentario());
        result.setPuntuacion(c.getPuntuacion());
        result.setFecha(c.getFecha());
        result.setIdPaciente(paciente.getIdUsuario());
        result.setIdPsicologo(psicologo.getIdUsuario());

        return result;
    }
}
