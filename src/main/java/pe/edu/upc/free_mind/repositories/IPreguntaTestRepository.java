package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.PreguntaTest;

//Repositorio para operaciones CRUD sobre PreguntaTest
@Repository
public interface IPreguntaTestRepository extends JpaRepository<PreguntaTest, Integer> {
    //Aquí se pueden agregar métodos personalizados si es necesario
}
