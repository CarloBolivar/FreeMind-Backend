package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Cita;

import java.util.List;

//Repositorio para operaciones CRUD sobre Cita
@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {


    //Reportes
    /*Carlo*/
    //Obtiene la cantidad de citas atendidas por cada psicólogo
    @Query(value = "SELECT u.nombre AS nombrePsicologo, COUNT(c.id_cita) AS cantidadCitas " +
            "FROM usuario u " +
            "INNER JOIN cita c ON u.id_usuario = c.id_psicologo " +
            "WHERE u.id_rol = (SELECT id_rol FROM rol WHERE nombre = 'PSICOLOGO') " +
            "GROUP BY u.nombre " +
            "ORDER BY cantidadCitas DESC", nativeQuery = true)
    public List<String[]> obtenerCantidadCitasPorPsicologo();


    /*Deyci*/
    //Obtiene la cantidad de citas por tipo de terapia
    @Query(value = "SELECT t.titulo AS name_terapia, t.descripcion, COUNT(c.id_cita) AS quantity_citas\n" +
            "FROM cita c \n" +
            "INNER JOIN terapia t ON c.id_terapia = t.id_terapia \n" +
            "GROUP BY t.titulo, t.descripcion\n" +
            "ORDER BY quantity_citas DESC", nativeQuery = true)
    public List<String[]> obtenerCantidadCitasPorTerapia();

    //Obtiene el monto total de ingresos generados por psicólogo
    @Query(value = "SELECT u.nombre, u.apellido, SUM(p.monto) AS total_ingresos " +
            "FROM usuario u " +
            "JOIN cita c ON u.id_usuario = c.id_psicologo " +
            "JOIN pago p ON c.id_cita = p.id_cita " +
            "GROUP BY u.id_usuario, u.nombre, u.apellido " +
            "ORDER BY total_ingresos DESC", nativeQuery = true)
    public List<String[]> TotalIngresosPsicologo();
}
