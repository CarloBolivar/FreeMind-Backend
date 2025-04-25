package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Test;
import pe.edu.upc.free_mind.repositories.ITestRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ITestService;

import java.util.List;

/**
 * Implementación de ITestService. Gestiona operaciones sobre la entidad Test.
 */
@Service
public class TestServiceImplement implements ITestService {

    /** Inyección del repositorio de Test */
    @Autowired
    private ITestRepository tR;

    /**
     * Inserta un nuevo test en la base de datos.
     * @param test Objeto Test a guardar
     */
    @Override
    public void insert(Test test) {
        tR.save(test);
    }

    /**
     * Retorna todos los test registrados.
     * @return Lista de objetos Test
     */
    @Override
    public List<Test> list() {
        return tR.findAll();
    }

    /**
     * Elimina un test por ID
     * @param id Identificador del test
     */
    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }

    /**
     * Retorna un test por ID
     * @param id Identificador buscado
     * @return Objeto Test o uno nuevo si no existe
     */
    @Override
    public Test listId(int id) {
        return tR.findById(id).orElse(new Test());
    }

    /**
     * Actualiza un test existente
     * @param test Objeto con datos actualizados
     */
    @Override
    public void update(Test test) {
        tR.save(test);
    }
}
