package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.TestRealizado;

//Repositorio para operaciones CRUD sobre TestRealizado
@Repository
public interface ITestRealizadoRepository extends JpaRepository<TestRealizado, Integer> {
    //Aquí se pueden agregar métodos personalizados si es necesario
}
