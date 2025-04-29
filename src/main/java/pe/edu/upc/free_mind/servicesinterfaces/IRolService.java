package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Rol;
import java.util.List;

// Interfaz que define los métodos de servicio para la entidad Rol
public interface IRolService {

    // Lista todos los roles registrados
    public List<Rol> list();

    //Inserta un nuevo rol en la base de datos
    public void insert(Rol rol);

    // Elimina un rol por su ID
    public void delete(int id);

    //Obtiene un rol por su ID.
    public Rol listId(int id);

    //Actualiza un rol existente en la base de datos
    public void update(Rol rol);
}