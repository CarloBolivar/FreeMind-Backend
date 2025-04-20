package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa el horario disponible de un psicólogo.
 */
@Entity
@Data
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;

    @Column(length = 50, nullable = false)
    private String dia;

    @Column(length = 10, nullable = false)
    private String horaInicio;

    @Column(length = 10, nullable = false)
    private String horaFin;
}
