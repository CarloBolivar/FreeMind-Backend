package pe.edu.upc.free_mind.dtos;

//DTO que representa la cantidad de recursos por terapia
public class CantidadRecursosPorTerapiaDTO {
    private String tipoTerapia;
    private long cantidadRecursos;

    public CantidadRecursosPorTerapiaDTO() {
    }

    public CantidadRecursosPorTerapiaDTO(String tipoTerapia, long cantidadRecursos) {
        this.tipoTerapia = tipoTerapia;
        this.cantidadRecursos = cantidadRecursos;
    }

    public String getTipoTerapia() {
        return tipoTerapia;
    }

    public void setTipoTerapia(String tipoTerapia) {
        this.tipoTerapia = tipoTerapia;
    }

    public long getCantidadRecursos() {
        return cantidadRecursos;
    }

    public void setCantidadRecursos(long cantidadRecursos) {
        this.cantidadRecursos = cantidadRecursos;
    }
}
