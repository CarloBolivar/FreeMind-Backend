package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.PreguntaTest;

/**
 * Repositorio JPA para la entidad PreguntaTest.
 */
public interface IPreguntaTestRepository extends JpaRepository<PreguntaTest, Integer> {
}
