package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Recurso;

//Repositorio para operaciones CRUD sobre Recurso
@Repository
public interface IRecursoRepository extends JpaRepository<Recurso, Integer> {
    //Aquí se pueden agregar métodos personalizados si es necesario
}
