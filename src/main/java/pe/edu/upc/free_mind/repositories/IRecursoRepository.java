package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.Recurso;

/**
 * Repositorio JPA para la entidad Recurso.
 */
public interface IRecursoRepository extends JpaRepository<Recurso, Integer> {
}
