package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.PreguntaTest;
import pe.edu.upc.free_mind.repositories.IPreguntaTestRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IPreguntaTestService;

import java.util.List;

/**
 * Implementación de IPreguntaTestService. Gestiona operaciones sobre la entidad PreguntaTest.
 */
@Service
public class PreguntaTestServiceImplement implements IPreguntaTestService {

    /** Repositorio para acceso a la base de datos de PreguntaTest */
    @Autowired
    private IPreguntaTestRepository pR;

    /**
     * Inserta una nueva pregunta
     * @param preguntaTest Objeto PreguntaTest a guardar
     */
    @Override
    public void insert(PreguntaTest preguntaTest) {
        pR.save(preguntaTest);
    }

    /**
     * Lista todas las preguntas
     * @return Lista de PreguntaTest
     */
    @Override
    public List<PreguntaTest> list() {
        return pR.findAll();
    }

    /**
     * Elimina una pregunta por ID
     * @param id Identificador de la pregunta
     */
    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    /**
     * Busca una pregunta por su ID
     * @param id ID buscado
     * @return PreguntaTest encontrada o nueva si no existe
     */
    @Override
    public PreguntaTest listId(int id) {
        return pR.findById(id).orElse(new PreguntaTest());
    }

    /**
     * Actualiza una pregunta existente
     * @param preguntaTest Objeto con datos modificados
     */
    @Override
    public void update(PreguntaTest preguntaTest) {
        pR.save(preguntaTest);
    }
}
