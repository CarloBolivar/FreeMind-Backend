package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Usuario;

/**
 * Permite operaciones CRUD básicas sin necesidad de implementación explícita.
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Aquí se pueden definir consultas personalizadas si se requiere

    Usuario findByCorreo(String correo);

    /* Monto total pagado de los clientes */
    @Query(value = "SELECT u.nombre, SUM(p.monto)\n" +
            " FROM Usuario u\n" +
            " INNER JOIN Pago p\n" +
            " on u.id_usuario = p.id_usuario\n" +
            " GROUP BY u.nombre\n", nativeQuery = true)
    public List<String[]> amountByUsuario();

    /*Cantidad de comentarios de los usuarios */
    @Query(value = "SELECT u.nombre, COUNT(c.id_comentario)\n" +
            " FROM Usuario u\n" +
            " INNER JOIN Comentario c\n" +
            " on u.id_usuario = c.id_usuario\n" +
            " GROUP BY u.nombre", nativeQuery = true)
    public List<String[]> comentByUsuario();
}



