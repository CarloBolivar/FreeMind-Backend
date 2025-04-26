package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.Test;

/**
 * DTO para transferir datos de preguntas de test.
 */
public class PreguntaTestDTO {

    private int idPreguntaTest;
    private String contenido;
    private String tipo;
    private Test test;

    public int getIdPreguntaTest() {
        return idPreguntaTest;
    }

    public void setIdPreguntaTest(int idPreguntaTest) {
        this.idPreguntaTest = idPreguntaTest;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Test getTest() { return test; }

    public void setTest(Test test) { this.test = test; }
}
