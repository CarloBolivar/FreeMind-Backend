package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa un comentario realizado por un paciente
 * hacia un psicólogo después de una cita.
 */
@Entity
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;

    @Column(length = 2000, nullable = false)
    private String comentario;

    @Column(nullable = false)
    private int puntuacion;

    @Column(nullable = false)
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Usuario paciente;

    @ManyToOne
    @JoinColumn(name = "idPsicologo")
    private Usuario psicologo;
}
