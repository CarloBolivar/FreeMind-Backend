package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Rol;

//Repositorio para operaciones CRUD sobre Rol
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    //Aquí se pueden agregar consultas personalizadas si es necesario
}
