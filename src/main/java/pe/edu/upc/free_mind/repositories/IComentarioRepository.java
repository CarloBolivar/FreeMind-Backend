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
    @Query("SELECT new pe.edu.upc.free_mind.dtos.CantidadComentariosPorUsuarioDTO(c.usuario.nombre, COUNT(c)) " +
            "FROM Comentario c " +
            "GROUP BY c.usuario.nombre")
    List<CantidadComentariosPorUsuarioDTO> obtenerCantidadComentariosPorUsuario();

}
