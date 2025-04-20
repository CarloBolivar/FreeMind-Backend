package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.Cita;

/**
 * Repositorio JPA para la entidad Cita.
 */
public interface ICitaRepository extends JpaRepository<Cita, Integer> {
}
