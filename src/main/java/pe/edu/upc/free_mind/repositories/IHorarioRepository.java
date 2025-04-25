package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Horario;

/**
 * Repositorio JPA para la entidad Horario.
 * Permite operaciones CRUD básicas sobre la tabla horario.
 */
@Repository
public interface IHorarioRepository extends JpaRepository<Horario, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren
}
