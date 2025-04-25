
package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Test;

/**
 * Repositorio JPA para la entidad Test.
 * Permite operaciones CRUD básicas sobre la tabla test.
 */
@Repository
public interface ITestRepository extends JpaRepository<Test, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren
}
