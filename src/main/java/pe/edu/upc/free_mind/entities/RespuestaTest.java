package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa una respuesta vinculada a una pregunta de test.
 */
@Entity
@Data
public class RespuestaTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @Column(length = 1000, nullable = false)
    private String contenido;

    @Column(nullable = false)
    private int valor;

    @ManyToOne
    @JoinColumn(name = "idPregunta")
    private PreguntaTest pregunta;
}
