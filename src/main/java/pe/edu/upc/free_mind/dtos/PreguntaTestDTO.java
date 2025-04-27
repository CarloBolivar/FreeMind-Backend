package pe.edu.upc.free_mind.dtos;

/**
 * DTO para transferir datos de la entidad PreguntaTest.
 */
public class PreguntaTestDTO {

    /** Identificador único de la pregunta */
    private int idPregunta;

    /** Contenido de la pregunta */
    private String pregunta;

    /** Identificador del test asociado */
    private int idTest;

    // Getters y Setters
    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }
}
