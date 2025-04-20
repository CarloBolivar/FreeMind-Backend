package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.free_mind.entities.Usuario;

/**
 * Repositorio JPA para la entidad Usuario.
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
