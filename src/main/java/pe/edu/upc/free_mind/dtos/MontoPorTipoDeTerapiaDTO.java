package pe.edu.upc.free_mind.dtos;

//DTO que representa el monto total generado por cada tipo de terapia
public class MontoPorTipoDeTerapiaDTO {

    //Tipo de terapia
    private String tipoTerapia;

    //Monto total generado por el tipo de terapia
    private Double montoTotal;

    //Getters y Setters
    public String getTipoTerapia() {
        return tipoTerapia;
    }

    public void setTipoTerapia(String tipoTerapia) {
        this.tipoTerapia = tipoTerapia;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
