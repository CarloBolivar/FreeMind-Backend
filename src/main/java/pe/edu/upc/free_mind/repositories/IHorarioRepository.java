package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.Horario;

/**
 * Repositorio JPA para la entidad Horario.
 */
public interface IHorarioRepository extends JpaRepository<Horario, Integer> {
}
