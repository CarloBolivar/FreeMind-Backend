package pe.edu.upc.free_mind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.free_mind.entities.Pago;

import java.util.List;

//Repositorio para operaciones CRUD sobre Pago
@Repository
public interface IPagoRepository extends JpaRepository<Pago, Integer> {

    //Reportes

    /*Carlo*/
    //Obtiene la suma de pagos agrupados por mes
    @Query(value = "SELECT p.mes, SUM(p.monto) FROM pago p GROUP BY p.mes ORDER BY p.mes", nativeQuery = true)
    List<String[]> obtenerSumaPagosPorMes();

    /*Erick*/
    //Obtiene el monto total generado por el tipo de terapia elegido
    @Query(value = "SELECT t.titulo AS tipoTerapia, SUM(p.monto) AS montoTotal " +
            "FROM pago p " +
            "INNER JOIN cita c ON p.id_cita = c.id_cita " +
            "INNER JOIN terapia t ON c.id_terapia = t.id_terapia " +
            "GROUP BY t.titulo " +
            "ORDER BY montoTotal DESC", nativeQuery = true)
    public List<String[]> obtenerMontoPorTipoDeTerapia();
}
