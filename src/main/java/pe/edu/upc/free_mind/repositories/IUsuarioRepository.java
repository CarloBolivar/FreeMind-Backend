package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Usuario;

import java.util.List;

//Repositorio para operaciones CRUD sobre Usuario
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    //Busca un usuario por su correo
    Usuario findByCorreo(String correo);

    //Reportes

    /*Renzo*/
    //Obtiene el monto total pagado por cada usuario
    @Query(value = "SELECT u.nombre, SUM(p.monto) " +
            "FROM Usuario u " +
            "INNER JOIN Pago p " +
            "ON u.id_usuario = p.id_usuario " +
            "GROUP BY u.nombre", nativeQuery = true)
    public List<String[]> amountByUsuario();

    //Obtiene la cantidad de comentarios por usuario
    @Query(value = "SELECT u.nombre, COUNT(c.id_comentario) " +
            "FROM Usuario u " +
            "INNER JOIN Comentario c " +
            "ON u.id_usuario = c.id_usuario " +
            "GROUP BY u.nombre", nativeQuery = true)
    public List<String[]> comentByUsuario();

    @Query(value = "SELECT r.nombre, COUNT(u.id_usuario)\n" +
            " FROM Usuario u\n" +
            " JOIN Rol r ON u.id_rol = r.id_rol\n" +
            " WHERE u.id_rol IN (1, 2)\n" +
            " GROUP BY r.nombre;\n", nativeQuery = true)
    public List<String[]> cantidadUsuario();
}
