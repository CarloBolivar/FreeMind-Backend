package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.TestRealizado;

/**
 * Repositorio JPA para la entidad TestRealizado.
 * Permite operaciones CRUD básicas sobre la tabla test_realizado.
 */
@Repository
public interface ITestRealizadoRepository extends JpaRepository<TestRealizado, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren
}