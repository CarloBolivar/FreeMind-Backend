package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.PreguntaTest;
import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la entidad PreguntaTest.
 * Encapsula la lógica de negocio relacionada a las preguntas de test.
 */
public interface IPreguntaTestService {

    /**
     * Lista todas las preguntas registradas.
     * @return Lista de objetos PreguntaTest
     */
    public List<PreguntaTest> list();

    /**
     * Inserta una nueva pregunta en la base de datos.
     * @param preguntaTest Objeto PreguntaTest a registrar
     */
    public void insert(PreguntaTest preguntaTest);

    /**
     * Elimina una pregunta por su ID.
     * @param id ID de la pregunta a eliminar
     */
    public void delete(int id);

    /**
     * Obtiene una pregunta por su ID.
     * @param id Identificador buscado
     * @return Objeto PreguntaTest correspondiente o uno nuevo si no existe
     */
    public PreguntaTest listId(int id);

    /**
     * Actualiza una pregunta existente.
     * @param preguntaTest Objeto con los nuevos datos
     */
    public void update(PreguntaTest preguntaTest);
}
