package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

// Entidad que representa una cita agendada entre un paciente y un psicólogo.
@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita;

    @Column(name = "estado", nullable = false)
    private int estado;

    @Column(name = "id_horario", nullable = false)
    private int idHorario;

    @Column(name = "id_paciente", nullable = false)
    private int idPaciente; // 🔁 antes: private Usuario paciente

    @Column(name = "id_psicologo", nullable = false)
    private int idPsicologo; // 🔁 antes: private Usuario psicologo

    @Column(name = "id_terapia")
    private Integer idTerapia; // 🔁 antes: private Terapia terapia

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

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdPsicologo() {
        return idPsicologo;
    }

    public void setIdPsicologo(int idPsicologo) {
        this.idPsicologo = idPsicologo;
    }

    public Integer getIdTerapia() {
        return idTerapia;
    }

    public void setIdTerapia(Integer idTerapia) {
        this.idTerapia = idTerapia;
    }
}
