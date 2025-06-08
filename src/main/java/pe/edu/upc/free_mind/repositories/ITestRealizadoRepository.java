package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.TestRealizado;

import java.util.List;

//Repositorio para operaciones CRUD sobre TestRealizado
@Repository
public interface ITestRealizadoRepository extends JpaRepository<TestRealizado, Integer> {
    //Aquí se pueden agregar métodos personalizados si es necesario

    /*Erick*/
    //Obtiene la cantidad de tests completados por mes (31 días)
    @Query(value = "SELECT EXTRACT(MONTH FROM fecha) AS mes, COUNT(id_test_realizado) AS cantidadTests " +
            "FROM test_realizado " +
            "WHERE resultado IS NOT NULL " +
            "GROUP BY mes " +
            "ORDER BY mes", nativeQuery = true)
    public  List<String[]> cantidadTestsPorMes();

}
