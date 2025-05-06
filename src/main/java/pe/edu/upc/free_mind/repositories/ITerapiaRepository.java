package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Terapia;

//Repositorio para operaciones CRUD sobre Terapia
@Repository
public interface ITerapiaRepository extends JpaRepository<Terapia, Integer> {
    //Aquí se pueden agregar métodos personalizados si es necesario
}
