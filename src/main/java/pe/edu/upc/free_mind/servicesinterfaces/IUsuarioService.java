package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Usuario;

import java.util.List;

//Interfaz que define los servicios relacionados a la entidad Usuario
public interface IUsuarioService {

    //Lista todos los usuarios registrados en el sistema
    public List<Usuario> list();

    //Inserta un nuevo usuario en el sistema
    public void insert(Usuario usuario);

    //Elimina un usuario específico del sistema basado en su ID
    public void delete(int id);

    //Busca un usuario en el sistema basado en su ID
    public Usuario listId(int id);

    //Actualiza los datos de un usuario existente en el sistema
    public void update(Usuario usuario);

   //Busca un usuario en el sistema utilizando su correo electrónico
    public default Usuario findByCorreo(String correo) {
        return null;
    }

    //Reportes
    /* Renzo*/
    public List<String[]> amountByUsuario();
    public List<String[]> comentByUsuario();
}
