package pe.edu.upc.free_mind.dtos;

public class MontoPorTipoDeTerapiaDTO {
    private String tipoTerapia;
    private Double montoTotal;

    public MontoPorTipoDeTerapiaDTO(String tipoTerapia, Double montoTotal) {
        this.tipoTerapia = tipoTerapia;
        this.montoTotal = montoTotal;
    }

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
