package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Pago;

import java.util.List;

/**
 * Repositorio JPA para la entidad Pago.
 * Permite operaciones CRUD básicas sobre la tabla pago.
 */
@Repository
public interface IPagoRepository extends JpaRepository<Pago, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren

    /**
     * Reportes
     */
    /*Carlo*/
    //la suma de pagos por mes
    @Query(value = "SELECT EXTRACT(MONTH FROM h.fecha) AS mes, SUM(p.monto) AS montoTotal " +
            "FROM pago p " +
            "INNER JOIN cita c ON p.id_cita = c.id_cita " +
            "INNER JOIN horario h ON c.id_horario = h.id_horario " +
            "GROUP BY mes " +
            "ORDER BY mes", nativeQuery = true)
    List<String[]> obtenerSumaPagosPorMes();
}
