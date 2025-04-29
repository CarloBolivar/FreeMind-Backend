package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Horario;
import java.util.List;

//Interfaz que define los métodos de servicio para la entidad Horario
public interface IHorarioService {

    //Lista todos los horarios registrados
    public List<Horario> list();

    //Inserta un nuevo horario en la base de datos
    public void insert(Horario horario);

    //Elimina un horario por su ID
    public void delete(int id);

    //Obtiene un horario por su ID
    public Horario listId(int id);

    //Actualiza un horario existente
    public void update(Horario horario);
}