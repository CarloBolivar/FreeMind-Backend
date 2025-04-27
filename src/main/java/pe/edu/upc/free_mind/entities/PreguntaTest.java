package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

/**
 * Entidad que representa una pregunta perteneciente a un test.
 */
@Entity
@Table(name = "pregunta_test")
public class PreguntaTest {

    /** Identificador único de la pregunta */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private int idPregunta;

    /** Contenido de la pregunta */
    @Column(name = "pregunta", nullable = false, columnDefinition = "text")
    private String pregunta;

    /** Test al que pertenece la pregunta */
    @ManyToOne
    @JoinColumn(name = "id_test", nullable = false)
    private Test test;

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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
