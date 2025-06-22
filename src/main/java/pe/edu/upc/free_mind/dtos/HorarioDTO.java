package pe.edu.upc.free_mind.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

//DTO para transferir datos de la entidad Horario
public class HorarioDTO {

    //Identificador único del horario
    private int idHorario;

    //Fecha disponible para el horario
    private LocalDate fecha;

    //Hora disponible para el horario
    private LocalTime hora;

    //Identificador del usuario (psicólogo) asociado al horario
    private int idUsuario;

    private boolean disponible;


    //Getters y Setters
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
