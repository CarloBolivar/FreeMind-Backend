package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.RespuestaTest;

//Repositorio para operaciones CRUD sobre RespuestaTest
@Repository
public interface IRespuestaTestRepository extends JpaRepository<RespuestaTest, Integer> {
    //Aquí se pueden agregar métodos personalizados si es necesario
}
