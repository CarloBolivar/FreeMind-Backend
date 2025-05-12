package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Terapia;
import java.util.List;

//Interfaz que define los métodos de servicio para la entidad Terapia
public interface ITerapiaService {

    //Lista todas las terapias registradas
    public List<Terapia> list();

    //Inserta una nueva terapia en la base de datos
    public void insert(Terapia terapia);

    //Elimina una terapia por su ID
    public void delete(int id);

    // Obtiene una terapia por su ID
    public Terapia listId(int id);

    //Actualiza una terapia existente
    public void update(Terapia terapia);
}
