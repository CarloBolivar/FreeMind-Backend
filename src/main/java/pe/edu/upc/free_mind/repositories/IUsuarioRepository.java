package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Usuario;

/**
 * Repositorio JPA para la entidad Usuario.
 * Permite operaciones CRUD básicas sin necesidad de implementación explícita.
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Aquí se pueden definir consultas personalizadas si se requiere
}
