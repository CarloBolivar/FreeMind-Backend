package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.TestRealizado;
import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la entidad TestRealizado.
 * Encapsula la lógica de negocio relacionada a los tests realizados por usuarios.
 */
public interface ITestRealizadoService {

    /**
     * Lista todos los tests realizados.
     * @return Lista de objetos TestRealizado
     */
    public List<TestRealizado> list();

    /**
     * Inserta un nuevo test realizado en la base de datos.
     * @param testRealizado Objeto TestRealizado a registrar
     */
    public void insert(TestRealizado testRealizado);

    /**
     * Elimina un test realizado por su ID.
     * @param id ID del test a eliminar
     */
    public void delete(int id);

    /**
     * Obtiene un test realizado por su ID.
     * @param id Identificador buscado
     * @return Objeto TestRealizado correspondiente o uno nuevo si no existe
     */
    public TestRealizado listId(int id);

    /**
     * Actualiza un test realizado existente.
     * @param testRealizado Objeto con los nuevos datos
     */
    public void update(TestRealizado testRealizado);
}
