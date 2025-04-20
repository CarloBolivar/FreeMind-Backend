package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.Rol;

/**
 * Repositorio JPA para la entidad Rol.
 */
public interface IRolRepository extends JpaRepository<Rol, Integer> {
}
