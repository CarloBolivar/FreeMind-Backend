package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Pago;

/**
 * Repositorio JPA para la entidad Pago.
 * Permite operaciones CRUD básicas sobre la tabla pago.
 */
@Repository
public interface IPagoRepository extends JpaRepository<Pago, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren
}
