package pe.edu.upc.free_mind.dtos;

/**
 * DTO para la entidad RespuestaTest.
 * Se utiliza para transferencia de datos del resultado de test.
 */
public class RespuestaTestDTO {

    private int idRespuesta;
    private int puntaje;
    private String nivel;

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
}
