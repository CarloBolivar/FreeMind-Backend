package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.PreguntaTest;

/**
 * DTO para la entidad RespuestaTest.
 * Se utiliza para transferencia de datos del resultado de test.
 */
public class RespuestaTestDTO {

    private int idRespuesta;
    private int puntaje;
    private String nivel;
    private PreguntaTest preguntaTest;

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public PreguntaTest getPreguntaTest() { return preguntaTest;}

    public void setPreguntaTest(PreguntaTest preguntaTest) { this.preguntaTest = preguntaTest; }
}
