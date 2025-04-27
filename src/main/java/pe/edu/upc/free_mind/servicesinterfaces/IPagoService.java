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
     * @return Lista de objetos Pago
     */
    public List<Pago> list();

    /**
     * Inserta un nuevo pago en la base de datos.
     * @param pago Objeto Pago a registrar
     */
    public void insert(Pago pago);

    /**
     * Elimina un pago por su ID.
     * @param id ID del pago a eliminar
     */
    public void delete(int id);

    /**
     * Obtiene un pago por su ID.
     * @param id Identificador buscado
     * @return Objeto Pago correspondiente o uno nuevo si no existe
     */
    public Pago listId(int id);

    /**
     * Actualiza un pago existente.
     * @param pago Objeto con los nuevos datos
     */
    public void update(Pago pago);

    /**
     * Obtiene la suma total de pagos realizados por mes.
     * @return Lista de String[] con los datos
     */
    public List<String[]> obtenerSumaPagosPorMes();
}
