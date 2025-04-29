package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.RespuestaTest;
import pe.edu.upc.free_mind.repositories.IRespuestaTestRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IRespuestaTestService;

import java.util.List;

//Implementación del servicio para la entidad RespuestaTest
@Service
public class RespuestaTestServiceImplement implements IRespuestaTestService {

    //Repositorio para operaciones CRUD sobre RespuestaTest
    @Autowired
    private IRespuestaTestRepository rR;

    //Inserta una nueva respuesta de test
    @Override
    public void insert(RespuestaTest respuestaTest) {
        rR.save(respuestaTest);
    }

    //Lista todas las respuestas de test registradas
    @Override
    public List<RespuestaTest> list() {
        return rR.findAll();
    }

    //Elimina una respuesta de test según su ID
    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    //Obtiene una respuesta de test por su ID
    @Override
    public RespuestaTest listId(int id) {
        return rR.findById(id).orElse(new RespuestaTest());
    }

    //Actualiza una respuesta de test existente
    @Override
    public void update(RespuestaTest respuestaTest) {
        rR.save(respuestaTest);
    }
}
