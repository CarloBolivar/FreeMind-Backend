package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Comentario;
import pe.edu.upc.free_mind.repositories.IComentarioRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IComentarioService;

import java.util.List;

/**
 * Implementación de IComentarioService. Gestiona operaciones sobre la entidad Comentario.
 */
@Service
public class ComentarioServiceImplement implements IComentarioService {

    /** Repositorio para acceso a la base de datos de Comentario */
    @Autowired
    private IComentarioRepository cR;

    /**
     * Inserta un nuevo comentario
     * @param comentario Objeto Comentario a guardar
     */
    @Override
    public void insert(Comentario comentario) {
        cR.save(comentario);
    }

    /**
     * Lista todos los comentarios
     * @return Lista de Comentario
     */
    @Override
    public List<Comentario> list() {
        return cR.findAll();
    }

    /**
     * Elimina un comentario por ID
     * @param id Identificador del comentario
     */
    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    /**
     * Busca un comentario por su ID
     * @param id ID buscado
     * @return Comentario encontrado o uno nuevo si no existe
     */
    @Override
    public Comentario listId(int id) {
        return cR.findById(id).orElse(new Comentario());
    }

    /**
     * Actualiza un comentario existente
     * @param comentario Objeto con datos modificados
     */
    @Override
    public void update(Comentario comentario) {
        cR.save(comentario);
    }
}
