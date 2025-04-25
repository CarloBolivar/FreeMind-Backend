package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    // Consultas personalizadas pueden añadirse aquí si se necesitan
}
