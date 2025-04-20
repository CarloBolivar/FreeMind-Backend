package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.Terapia;

/**
 * Repositorio JPA para la entidad Terapia.
 */
public interface ITerapiaRepository extends JpaRepository<Terapia, Integer> {
}
