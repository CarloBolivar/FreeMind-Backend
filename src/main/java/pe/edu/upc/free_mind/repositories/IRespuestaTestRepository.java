package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.RespuestaTest;

/**
 * Repositorio JPA para la entidad RespuestaTest.
 * Permite operaciones CRUD básicas sobre la tabla respuesta_test.
 */
@Repository
public interface IRespuestaTestRepository extends JpaRepository<RespuestaTest, Integer> {
    // Aquí se pueden añadir métodos personalizados si es necesario
}
