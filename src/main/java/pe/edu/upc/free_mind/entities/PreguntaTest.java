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
    private int idPreguntaTest;

    /** Contenido de la pregunta */
    @Column(name = "contenido", nullable = false, length = 500)
    private String contenido;

    /** Tipo de pregunta (opcional, puede ser múltiple, escala, etc.) */
    @Column(name = "tipo", length = 50)
    private String tipo;

    @ManyToOne
    @JoinColumn(name="idTest")
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
