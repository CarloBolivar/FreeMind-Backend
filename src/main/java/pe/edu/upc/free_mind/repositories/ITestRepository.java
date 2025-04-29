package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Test;

import java.util.List;

//Repositorio para operaciones CRUD sobre Test
@Repository
public interface ITestRepository extends JpaRepository<Test, Integer> {

    //Reportes

    /*Erick*/
    //Obtiene la cantidad de tests completados por mes
    @Query(value = "SELECT EXTRACT(MONTH FROM fecha_realizacion) AS mes, COUNT(id_test) AS cantidadTests " +
            "FROM test " +
            "WHERE estado = 'Completado' " +
            "GROUP BY mes " +
            "ORDER BY mes", nativeQuery = true)
    public List<String[]> cantidadTestsPorMes();
}
