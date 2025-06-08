package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.TestRealizado;
import pe.edu.upc.free_mind.repositories.ITestRealizadoRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ITestRealizadoService;

import java.util.List;

//Implementación del servicio para la entidad TestRealizado
@Service
public class TestRealizadoServiceImplement implements ITestRealizadoService {

    //Repositorio para operaciones CRUD sobre TestRealizado
    @Autowired
    private ITestRealizadoRepository trR;

    //Inserta un nuevo test realizado en la base de datos
    @Override
    public void insert(TestRealizado testRealizado) {
        trR.save(testRealizado);
    }

    //Lista todos los tests realizados
    @Override
    public List<TestRealizado> list() {
        return trR.findAll();
    }

    //Elimina un test realizado según su ID
    @Override
    public void delete(int id) {
        trR.deleteById(id);
    }

    //Obtiene un test realizado por su ID
    @Override
    public TestRealizado listId(int id) {
        return trR.findById(id).orElse(new TestRealizado());
    }

    //Actualiza un test realizado existente
    @Override
    public void update(TestRealizado testRealizado) {
        trR.save(testRealizado);
    }

    //Reportes

    /*Erick*/
    //Obtiene la cantidad de tests completados por mes
    @Override
    public List<String[]> cantidadTestsPorMes() {
        return trR.cantidadTestsPorMes();
    }
}
