package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.Terapia;

/**
 * DTO para transferir información de recursos educativos.
 */
public class RecursoDTO {

    private int idRecurso;
    private String tipo;
    private String descripcion;
    private String enlace;
    private Terapia terapia;


    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public Terapia getTerapia() {return terapia;}

    public void setTerapia(Terapia terapia) {this.terapia = terapia;}
}
