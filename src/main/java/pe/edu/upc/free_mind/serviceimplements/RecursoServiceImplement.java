package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Recurso;
import pe.edu.upc.free_mind.repositories.IRecursoRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IRecursoService;

import java.util.List;

/**
 * Implementación de IRecursoService. Gestiona operaciones sobre la entidad Recurso.
 */
@Service
public class RecursoServiceImplement implements IRecursoService {

    /** Repositorio para acceso a la base de datos de Recurso */
    @Autowired
    private IRecursoRepository rR;

    /**
     * Inserta un nuevo recurso
     * @param recurso Objeto Recurso a guardar
     */
    @Override
    public void insert(Recurso recurso) {
        rR.save(recurso);
    }

    /**
     * Lista todos los recursos
     * @return Lista de Recurso
     */
    @Override
    public List<Recurso> list() {
        return rR.findAll();
    }

    /**
     * Elimina un recurso por ID
     * @param id Identificador del recurso
     */
    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    /**
     * Busca un recurso por su ID
     * @param id ID buscado
     * @return Recurso encontrado o nuevo si no existe
     */
    @Override
    public Recurso listId(int id) {
        return rR.findById(id).orElse(new Recurso());
    }

    /**
     * Actualiza un recurso existente
     * @param recurso Objeto con datos modificados
     */
    @Override
    public void update(Recurso recurso) {
        rR.save(recurso);
    }
}
