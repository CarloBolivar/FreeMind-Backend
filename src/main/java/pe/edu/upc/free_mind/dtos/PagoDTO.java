package pe.edu.upc.free_mind.dtos;

import lombok.Data;

/**
 * DTO para la entidad Pago.
 */
@Data
public class PagoDTO {
    private int idPago;
    private double monto;
    private String metodo;
    private String fecha;
    private int idCita;
}
