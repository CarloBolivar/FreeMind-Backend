package pe.edu.upc.free_mind.servicesinterfaces;

import pe.edu.upc.free_mind.entities.Pago;
import java.util.List;

/**
 * Interfaz que define los métodos de servicio para la entidad Pago.
 * Encapsula la lógica de negocio relacionada a la gestión de pagos.
 */
public interface IPagoService {

    /**
     * Lista todos los pagos registrados.
     */
    public List<Pago> list();

    /**
     * Inserta un nuevo pago en la base de datos.
     */
    public void insert(Pago pago);

    /**
     * Elimina un pago por su ID.
     */
    public void delete(int id);

    /**
     * Obtiene un pago por su ID.
     */
    public Pago listId(int id);

    /**
     * Actualiza un pago existente.
     */
    public void update(Pago pago);

    /**
     * Reportes
     */
    /*Carlo*/
    public List<String[]> obtenerSumaPagosPorMes();

    /*Erick*/
    public List<String[]> obtenerMontoPorTipoDeTerapia();
}
