
package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

/**
 * Entidad que representa la respuesta del test del usuario.
 * Mapeada a la tabla "respuesta_test" en la base de datos.
 */
@Entity
@Table(name = "respuesta_test")
public class RespuestaTest {

    /** Identificador único de la respuesta */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    /** Puntaje obtenido por el usuario en el test */
    @Column(name = "puntaje", nullable = false)
    private int puntaje;

    /** Nivel de resultado interpretado a partir del puntaje */
    @Column(name = "nivel", length = 50)
    private String nivel;

    /** Relación con Tabla PreguntaTest */
    @ManyToOne
    @JoinColumn(name= "idPreguntaTest")
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

    public PreguntaTest getPreguntaTest() { return preguntaTest; }

    public void setPreguntaTest(PreguntaTest preguntaTest) { this.preguntaTest = preguntaTest; }
}
