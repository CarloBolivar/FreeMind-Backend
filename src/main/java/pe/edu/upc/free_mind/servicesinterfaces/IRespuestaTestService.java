package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.RespuestaTest;

import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la entidad RespuestaTest.
 * Se utiliza para encapsular la lógica de negocio relacionada a resultados de test.
 */
public interface IRespuestaTestService {

    /**
     * Lista todas las respuestas registradas en el sistema.
     * @return Lista de objetos RespuestaTest
     */
    public List<RespuestaTest> list();

    /**
     * Inserta una nueva respuesta de test.
     * @param respuestaTest Objeto RespuestaTest a registrar
     */
    public void insert(RespuestaTest respuestaTest);

    /**
     * Elimina una respuesta por su ID.
     * @param id ID de la respuesta a eliminar
     */
    public void delete(int id);

    /**
     * Obtiene una respuesta por su ID.
     * @param id Identificador de la respuesta
     * @return Objeto RespuestaTest encontrado
     */
    public RespuestaTest listId(int id);

    /**
     * Actualiza una respuesta existente.
     * @param respuestaTest Objeto RespuestaTest con los nuevos datos
     */
    public void update(RespuestaTest respuestaTest);
}
