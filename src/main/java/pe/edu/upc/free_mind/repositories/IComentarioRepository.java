package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.Comentario;

/**
 * Repositorio JPA para la entidad Comentario.
 */
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {
}
