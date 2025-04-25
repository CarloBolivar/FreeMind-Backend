package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidad que representa una terapia programada o realizada por un psicólogo a un paciente.
 */
@Entity
@Table(name = "terapia")
public class Terapia {

    /** Identificador único de la terapia */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTerapia;

    /** Fecha de la sesión de terapia */
    @Column(name = "fechaTerapia", nullable = false)
    private LocalDate fechaTerapia;

    /** Descripción de lo tratado o planificado en la terapia */
    @Column(name = "descripcion", length = 300)
    private String descripcion;

    /** Usuario psicólogo que realiza la terapia */
    @ManyToOne
    @JoinColumn(name = "idPsicologo")
    private Usuario psicologo;

    /** Usuario paciente que recibe la terapia */
    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Usuario paciente;

    public int getIdTerapia() {
        return idTerapia;
    }

    public void setIdTerapia(int idTerapia) {
        this.idTerapia = idTerapia;
    }

    public LocalDate getFechaTerapia() {
        return fechaTerapia;
    }

    public void setFechaTerapia(LocalDate fechaTerapia) {
        this.fechaTerapia = fechaTerapia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Usuario psicologo) {
        this.psicologo = psicologo;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }
}
