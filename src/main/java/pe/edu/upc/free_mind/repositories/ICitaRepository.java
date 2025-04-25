package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Cita;

/**
 * Repositorio JPA para la entidad Cita.
 * Permite operaciones CRUD básicas sobre la tabla cita.
 */
@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren
}
