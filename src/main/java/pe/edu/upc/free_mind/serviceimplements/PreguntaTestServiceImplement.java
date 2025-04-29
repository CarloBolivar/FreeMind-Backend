package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.PreguntaTest;
import pe.edu.upc.free_mind.repositories.IPreguntaTestRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IPreguntaTestService;

import java.util.List;

//Implementación del servicio para la entidad PreguntaTest
@Service
public class PreguntaTestServiceImplement implements IPreguntaTestService {

    //Repositorio para operaciones CRUD sobre PreguntaTest
    @Autowired
    private IPreguntaTestRepository pR;

    //Inserta una nueva pregunta en la base de datos
    @Override
    public void insert(PreguntaTest preguntaTest) {
        pR.save(preguntaTest);
    }

    //Lista todas las preguntas registradas
    @Override
    public List<PreguntaTest> list() {
        return pR.findAll();
    }

    //Elimina una pregunta según su ID
    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    //Obtiene una pregunta por su ID
    @Override
    public PreguntaTest listId(int id) {
        return pR.findById(id).orElse(new PreguntaTest());
    }

    //Actualiza una pregunta existente
    @Override
    public void update(PreguntaTest preguntaTest) {
        pR.save(preguntaTest);
    }
}
