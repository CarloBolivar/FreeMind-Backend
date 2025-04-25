package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.PreguntaTest;

/**
 * Repositorio JPA para la entidad PreguntaTest.
 * Permite operaciones CRUD básicas sobre la tabla pregunta_test.
 */
@Repository
public interface IPreguntaTestRepository extends JpaRepository<PreguntaTest, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren
}
