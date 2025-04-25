package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.Usuario;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO para transferir datos del horario disponible de un usuario.
 */
public class HorarioDTO {

    private int idHorario;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
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
