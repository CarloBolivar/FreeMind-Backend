package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Horario;
import pe.edu.upc.free_mind.repositories.IHorarioRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IHorarioService;
import pe.edu.upc.free_mind.dtos.HorarioDTO;
import java.util.stream.Collectors;

import java.util.List;

//Implementación del servicio para la entidad Horario
@Service
public class HorarioServiceImplement implements IHorarioService {

    //Repositorio para operaciones CRUD sobre Horario
    @Autowired
    private IHorarioRepository hR;

    //Inserta un nuevo horario en la base de datos
    @Override
    public void insert(Horario horario) {
        hR.save(horario);
    }

    //Lista todos los horarios registrados
    @Override
    public List<Horario> list() {
        return hR.findAll();
    }

    //Elimina un horario según su ID
    @Override
    public void delete(int id) {
        hR.deleteById(id);
    }

    //Obtiene un horario por su ID
    @Override
    public Horario listId(int id) {
        return hR.findById(id).orElse(new Horario());
    }

    //Actualiza un horario existente
    @Override
    public void update(Horario horario) {
        hR.save(horario);
    }

    @Override
    public List<HorarioDTO> listDTO() {
        return hR.findAll().stream().map(horario -> {
            HorarioDTO dto = new HorarioDTO();
            dto.setIdHorario(horario.getIdHorario());
            dto.setFecha(horario.getFecha());
            dto.setHora(horario.getHora());
            dto.setDisponible(horario.isDisponible());
            dto.setIdUsuario(horario.getUsuario().getIdUsuario());
            dto.setNombreUsuario(horario.getUsuario().getNombre()); // Aquí llenas el campo
            return dto;
        }).collect(Collectors.toList());
    }
}
