package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.dtos.CantidadComentariosPorUsuarioDTO;
import pe.edu.upc.free_mind.entities.Comentario;

import java.util.List;

//Repositorio para operaciones CRUD sobre Comentario
@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {
    //Aquí se pueden agregar métodos personalizados si es necesario

    //Reportes
    /*Mauricio*/
    @Query("SELECT new pe.edu.upc.free_mind.dtos.CantidadComentariosPorUsuarioDTO(c.usuario.nombre, COUNT(c)) " +
            "FROM Comentario c " +
            "GROUP BY c.usuario.nombre")
    List<CantidadComentariosPorUsuarioDTO> obtenerCantidadComentariosPorUsuario();

    /*Deyci*/
    //Obtiene la cantidad de comentarios negativos de un psicologo
    // en base a las puntuaciones recibidas
    @Query(value="SELECT \n" +
            "    u.nombre AS nombre_psicologo,\n" +
            "    COUNT(c.id_comentario) AS comentarios_negativos\n" +
            "FROM comentario c\n" +
            "JOIN usuario u ON c.usuario_id_usuario = u.id_usuario\n" +
            "WHERE u.id_rol = (SELECT id_rol FROM rol WHERE nombre = 'Psicólogo')\n" +
            "  AND c.puntuacion <= 2\n" +
            "GROUP BY u.nombre\n" +
            "ORDER BY comentarios_negativos DESC;",nativeQuery = true)
    public List<String[]> obtenerCantComentariosNegativosPorPsicologo();


}
