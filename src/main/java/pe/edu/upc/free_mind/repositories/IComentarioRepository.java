package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Comentario;

//Repositorio para operaciones CRUD sobre Comentario
@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {
    //Aquí se pueden agregar métodos personalizados si es necesario
}
