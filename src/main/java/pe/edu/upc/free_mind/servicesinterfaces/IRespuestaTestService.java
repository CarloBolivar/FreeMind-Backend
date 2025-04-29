package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.RespuestaTest;

import java.util.List;

//Interfaz que define los métodos de servicio para la entidad RespuestaTest
public interface IRespuestaTestService {

    //Lista todas las respuestas registradas en el sistema
    public List<RespuestaTest> list();

    //Inserta una nueva respuesta de test
    public void insert(RespuestaTest respuestaTest);

    //Elimina una respuesta por su ID
    public void delete(int id);

    //Obtiene una respuesta por su ID
    public RespuestaTest listId(int id);

    //Actualiza una respuesta existente
    public void update(RespuestaTest respuestaTest);
}
