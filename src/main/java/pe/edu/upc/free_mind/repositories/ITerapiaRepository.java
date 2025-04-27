package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.dtos.MontoPorTipoDeTerapiaDTO;
import pe.edu.upc.free_mind.entities.Terapia;
import pe.edu.upc.free_mind.entities.Pago;

import java.util.List;

/**
 * Repositorio JPA para la entidad Terapia.
 * Permite operaciones CRUD básicas sobre la tabla terapia.
 */

@Repository
public interface ITerapiaRepository extends JpaRepository<Terapia, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren
    
    @Query("""
        SELECT new pe.edu.upc.free_mind.dtos.MontoPorTipoDeTerapiaDTO(
            t.tipo, SUM(p.monto)
        )
        FROM Pago p
        JOIN p.terapia t
        GROUP BY t.tipo
    """)
    List<MontoPorTipoDeTerapiaDTO> obtenerMontoTotalPorTipoTerapia();
}
