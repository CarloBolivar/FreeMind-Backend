package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.PreguntaTest;
import java.util.List;

//nterfaz que define los métodos de servicio para la entidad PreguntaTest
public interface IPreguntaTestService {

    //Lista todas las preguntas registradas
    public List<PreguntaTest> list();

    //Inserta una nueva pregunta en la base de datos
    public void insert(PreguntaTest preguntaTest);

    //Elimina una pregunta por su ID
    public void delete(int id);

    //Obtiene una pregunta por su ID.
    public PreguntaTest listId(int id);

    //Actualiza una pregunta existente
    public void update(PreguntaTest preguntaTest);
}
