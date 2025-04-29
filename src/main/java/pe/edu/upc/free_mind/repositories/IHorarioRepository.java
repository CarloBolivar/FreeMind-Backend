package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Horario;

//Repositorio para operaciones CRUD sobre Horario
@Repository
public interface IHorarioRepository extends JpaRepository<Horario, Integer> {
    //Aquí se pueden agregar métodos personalizados si es necesario
}
