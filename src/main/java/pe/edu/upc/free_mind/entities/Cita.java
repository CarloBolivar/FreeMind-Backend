package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Entidad que representa una cita agendada entre paciente y psicólogo.
 */
@Entity
@Table(name = "cita")
public class Cita {

    /** Identificador único de la cita */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita;

    /** Fecha programada para la cita */
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    /** Hora programada para la cita */
    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    /** Modalidad de la cita (presencial o virtual) */
    @Column(name = "modalidad", length = 50)
    private String modalidad;

    /** Motivo o asunto principal de la cita */
    @Column(name = "motivo", length = 200)
    private String motivo;

    /** Relación con el usuario (psicólogo o paciente) */
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
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

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
