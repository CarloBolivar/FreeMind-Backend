package pe.edu.upc.free_mind.dtos;

/**
 * DTO para representar la suma total de pagos realizados por mes.
 */
public class SumaPagosPorMesDTO {

    /** Mes del pago */
    private int mes;

    /** Monto total pagado en el mes */
    private Double montoTotal;

    // Getters y Setters
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
