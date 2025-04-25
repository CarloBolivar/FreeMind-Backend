package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO para transferir datos de la entidad Cita.
 * Utilizado en la capa de presentación.
 */
public class CitaDTO {

    private int idCita;
    private LocalDate fecha;
    private LocalTime hora;
    private String modalidad;
    private String motivo;
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
