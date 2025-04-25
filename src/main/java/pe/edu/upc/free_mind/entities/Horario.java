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

    /** Hora de inicio de disponibilidad */
    @Column(name = "horaInicio", nullable = false)
    private LocalTime horaInicio;

    /** Hora de fin de disponibilidad */
    @Column(name = "horaFin", nullable = false)
    private LocalTime horaFin;

    /** Usuario asociado (psicólogo) */
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

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

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
