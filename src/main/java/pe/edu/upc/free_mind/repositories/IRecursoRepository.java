package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.dtos.CantidadRecursosPorTerapiaDTO;
import pe.edu.upc.free_mind.entities.Recurso;

import java.util.List;

//Repositorio para operaciones CRUD sobre Recurso
@Repository
public interface IRecursoRepository extends JpaRepository<Recurso, Integer> {
    //Aquí se pueden agregar métodos personalizados si es necesario

    //Reportes
    /*Mauricio*/
    @Query("SELECT new pe.edu.upc.free_mind.dtos.CantidadRecursosPorTerapiaDTO(r.terapia.titulo, COUNT(r)) " +
            "FROM Recurso r " +
            "GROUP BY r.terapia.titulo")
    List<CantidadRecursosPorTerapiaDTO> obtenerCantidadRecursosPorTerapia();

}
