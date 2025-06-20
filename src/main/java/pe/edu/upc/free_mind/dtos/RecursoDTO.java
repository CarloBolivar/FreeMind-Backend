package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.Terapia;

//DTO para transferir información de los recursos
public class RecursoDTO {

    //Identificador único del recurso
    private int idRecurso;

    //Tipo de recurso (por ejemplo, video, documento, enlace)
    private String tipo;

    //URL del recurso
    private String url;

    //Identificador de la terapia asociada al recurso
    private Terapia terapia;

    //Getters y Setters

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Terapia getTerapia() {
        return terapia;
    }

    public void setTerapia(Terapia terapia) {
        this.terapia = terapia;
    }
}
