package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Recurso;

/**
 * Repositorio JPA para la entidad Recurso.
 * Permite operaciones CRUD básicas sobre la tabla recurso.
 */
@Repository
public interface IRecursoRepository extends JpaRepository<Recurso, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren
}
