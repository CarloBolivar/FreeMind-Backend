package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.TestRealizado;
import pe.edu.upc.free_mind.repositories.ITestRealizadoRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ITestRealizadoService;

import java.util.List;

/**
 * Implementación de ITestRealizadoService. Gestiona operaciones sobre la entidad TestRealizado.
 */
@Service
public class TestRealizadoServiceImplement implements ITestRealizadoService {

    /** Repositorio para acceso a la base de datos de TestRealizado */
    @Autowired
    private ITestRealizadoRepository trR;

    /**
     * Inserta un nuevo test realizado
     * @param testRealizado Objeto TestRealizado a guardar
     */
    @Override
    public void insert(TestRealizado testRealizado) {
        trR.save(testRealizado);
    }

    /**
     * Lista todos los tests realizados
     * @return Lista de TestRealizado
     */
    @Override
    public List<TestRealizado> list() {
        return trR.findAll();
    }

    /**
     * Elimina un test realizado por ID
     * @param id Identificador del test realizado
     */
    @Override
    public void delete(int id) {
        trR.deleteById(id);
    }

    /**
     * Busca un test realizado por su ID
     * @param id ID buscado
     * @return TestRealizado encontrado o uno nuevo si no existe
     */
    @Override
    public TestRealizado listId(int id) {
        return trR.findById(id).orElse(new TestRealizado());
    }

    /**
     * Actualiza un test realizado existente
     * @param testRealizado Objeto con datos modificados
     */
    @Override
    public void update(TestRealizado testRealizado) {
        trR.save(testRealizado);
    }
}
