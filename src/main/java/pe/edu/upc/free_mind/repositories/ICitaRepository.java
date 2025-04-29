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

    /**
     * Reportes
     */
    /*Deyci*/
    /*Cantidad de citas por tipo de terapia*/
    @Query(value="select\n" +
            "    t.titulo as name_terapia,\n" +
            "    COUNT(c.id_cita) as quantity_citas\n" +
            "from cita c\n" +
            "inner join terapia t\n " +
            "on c.id_terapia = t.id_terapia\n" +
            "group by t.titulo\n" +
            "order by quantity_citas desc\n ",nativeQuery=true)
    public List<String[]> QuantityCitaByTerapia();

    /*Monto total de ingresos por psicologo*/
   @Query(value ="SELECT u.nombre, u.apellido, SUM(p.monto) AS total_ingresos\n" +
           "FROM usuario u\n" +
           "JOIN cita c ON u.id_usuario = c.id_psicologo\n" +
           "JOIN pago p ON c.id_cita = p.id_cita\n" +
           "GROUP BY u.id_usuario, u.nombre, u.apellido\n" +
           "ORDER BY total_ingresos DESC;", nativeQuery = true)
   public List<String[]> TotalIngresosPsicologo();

}
