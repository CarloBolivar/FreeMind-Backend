package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.Usuario;
import java.time.LocalDate;

/**
 * DTO para transferir información relacionada a las sesiones de terapia.
 */
public class TerapiaDTO {

    private int idTerapia;
    private LocalDate fechaTerapia;
    private String descripcion;
    private Usuario psicologo;
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
