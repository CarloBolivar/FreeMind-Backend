package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

// Entidad que representa una respuesta de un usuario a una pregunta de un test.
@Entity
@Table(name = "respuesta_test")
public class RespuestaTest {

    // Identificador único de la respuesta
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    // Contenido de la respuesta proporcionada
    @Column(name = "respuesta", nullable = false, columnDefinition = "TEXT")
    private String respuesta;

    // Relación hacia la pregunta del test
    @ManyToOne
    @JoinColumn(name = "id_pregunta", nullable = false)
    private PreguntaTest preguntaTest;

    // Relación hacia el usuario que respondió
    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario", nullable = false)
    private Usuario usuario;

    // Getters y Setters
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

    public PreguntaTest getPreguntaTest() {
        return preguntaTest;
    }

    public void setPreguntaTest(PreguntaTest preguntaTest) {
        this.preguntaTest = preguntaTest;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
