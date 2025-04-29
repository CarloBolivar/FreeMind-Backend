package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.TestRealizado;
import java.util.List;

//Interfaz que define los métodos de servicio para la entidad TestRealizado.
public interface ITestRealizadoService {

    //Lista todos los tests realizados.
    public List<TestRealizado> list();

    //Inserta un nuevo test realizado en la base de datos.
    public void insert(TestRealizado testRealizado);

    //Elimina un test realizado por su ID
    public void delete(int id);

    //Obtiene un test realizado por su ID
    public TestRealizado listId(int id);

    //Actualiza un test realizado existente
    public void update(TestRealizado testRealizado);
}
