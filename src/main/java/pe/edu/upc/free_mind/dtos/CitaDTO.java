package pe.edu.upc.free_mind.dtos;

//DTO para transferir datos de la entidad Cita
public class CitaDTO {

    //Identificador único de la cita
    private int idCita;

    //Identificador del horario asociado a la cita
    private int idHorario;

    //Estado actual de la cita (por ejemplo, programado, completado, cancelado)
    private int estado;

    //Identificador del paciente asociado a la cita
    private int idPaciente;

    //Identificador del psicólogo asociado a la cita
    private int idPsicologo;

    //Identificador de la terapia asociada a la cita (puede ser nulo)
    private Integer idTerapia;

    //Getters y Setters
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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
