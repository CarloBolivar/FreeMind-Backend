package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Horario;
import pe.edu.upc.free_mind.repositories.IHorarioRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IHorarioService;

import java.util.List;

/**
 * Implementación de IHorarioService. Gestiona operaciones sobre la entidad Horario.
 */
@Service
public class HorarioServiceImplement implements IHorarioService {

    /** Repositorio para acceso a la base de datos de Horario */
    @Autowired
    private IHorarioRepository hR;

    /**
     * Inserta un nuevo horario
     * @param horario Objeto Horario a guardar
     */
    @Override
    public void insert(Horario horario) {
        hR.save(horario);
    }

    /**
     * Lista todos los horarios
     * @return Lista de Horario
     */
    @Override
    public List<Horario> list() {
        return hR.findAll();
    }

    /**
     * Elimina un horario por ID
     * @param id Identificador del horario
     */
    @Override
    public void delete(int id) {
        hR.deleteById(id);
    }

    /**
     * Busca un horario por su ID
     * @param id ID buscado
     * @return Horario encontrado o uno nuevo si no existe
     */
    @Override
    public Horario listId(int id) {
        return hR.findById(id).orElse(new Horario());
    }

    /**
     * Actualiza un horario existente
     * @param horario Objeto con datos modificados
     */
    @Override
    public void update(Horario horario) {
        hR.save(horario);
    }
}
