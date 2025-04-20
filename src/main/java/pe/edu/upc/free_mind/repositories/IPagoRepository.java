package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.Pago;

/**
 * Repositorio JPA para la entidad Pago.
 */
public interface IPagoRepository extends JpaRepository<Pago, Integer> {
}
