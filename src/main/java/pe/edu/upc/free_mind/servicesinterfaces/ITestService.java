package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Test;
import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la entidad Test.
 * Encapsula la lógica de negocio relacionada a la gestión de test.
 */
public interface ITestService {

    /**
     * Lista todos los test registrados.
     * @return Lista de objetos Test
     */
    public List<Test> list();

    /**
     * Inserta un nuevo test en la base de datos.
     * @param test Objeto Test a registrar
     */
    public void insert(Test test);

    /**
     * Elimina un test por su ID.
     * @param id ID del test a eliminar
     */
    public void delete(int id);

    /**
     * Obtiene un test por su ID.
     * @param id Identificador buscado
     * @return Objeto Test correspondiente o uno nuevo si no existe
     */
    public Test listId(int id);

    /**
     * Actualiza un test existente.
     * @param test Objeto con los nuevos datos
     */
    public void update(Test test);
}
