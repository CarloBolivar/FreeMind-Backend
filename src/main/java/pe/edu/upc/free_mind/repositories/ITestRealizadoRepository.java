package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.TestRealizado;

/**
 * Repositorio JPA para la entidad TestRealizado.
 */
public interface ITestRealizadoRepository extends JpaRepository<TestRealizado, Integer> {
}
