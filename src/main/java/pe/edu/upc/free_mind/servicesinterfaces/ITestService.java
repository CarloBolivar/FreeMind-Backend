package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Test;
import java.util.List;

//Interfaz que define los métodos de servicio para la entidad Test
public interface ITestService {

    //Lista todos los test registrados
    public List<Test> list();

    //Inserta un nuevo test en la base de datos
    public void insert(Test test);

    //Elimina un test por su ID
    public void delete(int id);

    //Obtiene un test por su ID
    public Test listId(int id);

    //Actualiza un test existente
    public void update(Test test);

    //Reportes
    /*Erick*/
    //Obtiene la cantidad de tests completados por mes
    public List<String[]> cantidadTestsPorMes();
}
