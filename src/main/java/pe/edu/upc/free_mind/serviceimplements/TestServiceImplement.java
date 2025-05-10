package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Test;
import pe.edu.upc.free_mind.repositories.ITestRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ITestService;

import java.util.List;

//Implementación de ITestService. Gestiona operaciones sobre la entidad Test
@Service
public class TestServiceImplement implements ITestService {

    // Repositorio para operaciones CRUD sobre los tests
    @Autowired
    private ITestRepository tR;

    // Inserta un nuevo test en la base de datos
    @Override
    public void insert(Test test) {
        tR.save(test);
    }

    //Retorna todos los test registrados
    @Override
    public List<Test> list() {
        return tR.findAll();
    }

    //Elimina un test por ID
    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }

    //Retorna un test por ID
    @Override
    public Test listId(int id) {
        return tR.findById(id).orElse(new Test());
    }

    // Actualiza un test existente
    @Override
    public void update(Test test) {
        tR.save(test);
    }

    //Reportes

    /*Erick*/
    //Obtiene la cantidad de tests completados por mes
    @Override
    public List<String[]> cantidadTestsPorMes() {
        return tR.cantidadTestsPorMes();
    }
}
