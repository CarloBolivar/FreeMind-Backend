package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

/**
 * Entidad que representa una cita agendada entre un paciente y un psicólogo.
 */
@Entity
@Table(name = "cita")
public class Cita {

    /** Identificador único de la cita */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita;

    /** Estado de la cita (por ejemplo, programado, completado, cancelado) */
    @Column(name = "estado", nullable = false)
    private int estado;

    /** Relación con el horario asignado a la cita */
    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;

    /** Relación con el paciente (usuario que recibe la cita) */
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Usuario paciente;

    /** Relación con el psicólogo (usuario que brinda la cita) */
    @ManyToOne
    @JoinColumn(name = "id_psicologo", nullable = false)
    private Usuario psicologo;

    /** Relación con la terapia asociada a la cita (opcional) */
    @ManyToOne
    @JoinColumn(name = "id_terapia")
    private Terapia terapia;

    // Getters y Setters
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public Usuario getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Usuario psicologo) {
        this.psicologo = psicologo;
    }

    public Terapia getTerapia() {
        return terapia;
    }

    public void setTerapia(Terapia terapia) {
        this.terapia = terapia;
    }
}
