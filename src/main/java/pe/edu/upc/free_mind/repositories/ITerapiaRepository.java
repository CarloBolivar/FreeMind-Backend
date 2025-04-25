package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Terapia;

/**
 * Repositorio JPA para la entidad Terapia.
 * Permite operaciones CRUD básicas sobre la tabla terapia.
 */
@Repository
public interface ITerapiaRepository extends JpaRepository<Terapia, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren
}
