package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Comentario;

/**
 * Repositorio JPA para la entidad Comentario.
 * Permite operaciones CRUD básicas sobre la tabla comentario.
 */
@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren
}
