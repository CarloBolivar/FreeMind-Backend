package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa una pregunta dentro de un test psicológico.
 */
@Entity
@Data
public class PreguntaTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPregunta;

    @Column(length = 1000, nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "idTest")
    private Test test;
}
