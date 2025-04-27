package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Entidad que representa un horario disponible para un usuario (psicólogo).
 */
@Entity
@Table(name = "horario")
public class Horario {

    /** Identificador único del horario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;

    /** Fecha del horario disponible */
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    /** Hora disponible */
    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    /** Usuario asociado (psicólogo) */
    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario", nullable = false)
    private Usuario usuario;

    // Getters y Setters
    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
