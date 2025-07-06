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
            "FROM usuario u " +
            "INNER JOIN cita c ON u.id_usuario = c.id_paciente " +
            "INNER JOIN pago p ON c.id_cita = p.id_cita " +
            "GROUP BY u.nombre", nativeQuery = true)
    List<String[]> amountByUsuario();

      //Obtiene la cantidad de usuarios por rol
    @Query(value = "SELECT r.nombre, COUNT(u.id_usuario)\n" +
            " FROM Usuario u\n" +
            " JOIN Rol r ON u.id_rol = r.id_rol\n" +
            " WHERE u.id_rol IN (1, 2)\n" +
            " GROUP BY r.nombre;\n", nativeQuery = true)
    public List<String[]> cantidadUsuario();

    //Obtiene la cantidad de psicologos activos
    @Query(value = "SELECT u.id_usuario, CONCAT(u.nombre,' ', u.apellido) AS nombre_completo, u.especialidad " +
            "FROM Usuario u " +
            "WHERE u.id_rol = '1' and u.enabled is true ",nativeQuery = true )
    public List<String[]> getPsicologosActivos();


    //Filtro
    List<Usuario> findByEspecialidad(String especialidad);
    List<Usuario> findByRolIdRol(Integer idRol);
    List<Usuario> findByEspecialidadAndRolIdRol(String especialidad, Integer idRol);
}
