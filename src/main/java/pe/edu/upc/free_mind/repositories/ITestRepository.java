package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.Test;

/**
 * Repositorio JPA para la entidad Test.
 */
public interface ITestRepository extends JpaRepository<Test, Integer> {
}
