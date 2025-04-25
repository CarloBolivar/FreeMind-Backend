package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.RespuestaTest;
import pe.edu.upc.free_mind.repositories.IRespuestaTestRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IRespuestaTestService;

import java.util.List;

/**
 * Implementación de la interfaz IRespuestaTestService.
 * Gestiona las operaciones sobre resultados de test realizados por usuarios.
 */
@Service
public class RespuestaTestServiceImplement implements IRespuestaTestService {

    /** Repositorio para acceder a la base de datos de respuestas */
    @Autowired
    private IRespuestaTestRepository rR;

    /**
     * Inserta una nueva respuesta de test
     * @param respuestaTest Objeto a guardar
     */
    @Override
    public void insert(RespuestaTest respuestaTest) {
        rR.save(respuestaTest);
    }

    /**
     * Lista todas las respuestas de test
     * @return Lista de objetos RespuestaTest
     */
    @Override
    public List<RespuestaTest> list() {
        return rR.findAll();
    }

    /**
     * Elimina una respuesta por su ID
     * @param id Identificador a eliminar
     */
    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    /**
     * Obtiene una respuesta específica por su ID
     * @param id Identificador buscado
     * @return Objeto RespuestaTest correspondiente o uno vacío si no existe
     */
    @Override
    public RespuestaTest listId(int id) {
        return rR.findById(id).orElse(new RespuestaTest());
    }

    /**
     * Actualiza una respuesta existente
     * @param respuestaTest Objeto con los datos nuevos
     */
    @Override
    public void update(RespuestaTest respuestaTest) {
        rR.save(respuestaTest);
    }
}
