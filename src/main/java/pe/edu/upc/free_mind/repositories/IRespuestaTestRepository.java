package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.RespuestaTest;

/**
 * Repositorio JPA para la entidad RespuestaTest.
 */
public interface IRespuestaTestRepository extends JpaRepository<RespuestaTest, Integer> {
}
