package pe.edu.upc.free_mind.dtos;

//DTO para transferir datos de la entidad RespuestaTest
public class RespuestaTestDTO {

    //Identificador único de la respuesta
    private int idRespuesta;

    //Contenido de la respuesta proporcionada
    private String respuesta;

    //Identificador de la pregunta asociada
    private int idPregunta;

    //Identificador del usuario que respondió
    private int idUsuario;

    //Getters y Setters
    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
