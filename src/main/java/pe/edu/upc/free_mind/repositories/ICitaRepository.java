package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Cita;

import java.util.List;

/**
 * Repositorio JPA para la entidad Cita.
 * Permite operaciones CRUD básicas sobre la tabla cita.
 */
@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {
    // Métodos personalizados pueden agregarse aquí si se requieren

    @Query(value = "SELECT u.nombre AS nombrePsicologo, COUNT(c.id_cita) AS cantidadCitas " +
            "FROM usuario u " +
            "INNER JOIN cita c ON u.id_usuario = c.id_psicologo " +
            "WHERE u.id_rol = (SELECT id_rol FROM rol WHERE nombre = 'Psicólogo') " +
            "GROUP BY u.nombre " +
            "ORDER BY cantidadCitas DESC", nativeQuery = true)
    List<String[]> obtenerCantidadCitasPorPsicologo();

    /*Deyci*/
    @Query(value="select\n" +
            "    t.nombre as name_terapia,\n" +
            "    COUNT(c.id_cita) as quantity_citas\n" +
            "from cita c\n" +
            "inner join terapia t\n " +
            "on c.id_terapia = t.id_terapia\n" +
            "group by t.nombre\n" +
            "order by quantity_citas desc\n ",nativeQuery=true)
    public List<String[]> QuantityCitaByTerapia();


}
