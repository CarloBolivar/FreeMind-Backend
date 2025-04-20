package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa una cita agendada entre un paciente y un psicólogo.
 */
@Entity
@Data
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita;

    @Column(length = 10, nullable = false)
    private String fecha;

    @Column(length = 10, nullable = false)
    private String hora;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Usuario paciente;

    @ManyToOne
    @JoinColumn(name = "idPsicologo")
    private Usuario psicologo;

    @ManyToOne
    @JoinColumn(name = "idHorario")
    private Horario horario;
}
