package pe.edu.upc.free_mind.dtos;

import java.time.LocalDate;

/**
 * DTO para transferir datos relacionados a comentarios realizados por usuarios.
 */
public class ComentarioDTO {

    /** Identificador único del comentario */
    private int idComentario;

    /** Contenido del comentario */
    private String comentario;

    /** Puntuación asignada en el comentario */
    private int puntuacion;

    /** Fecha en la que se realizó el comentario */
    private LocalDate fecha;

    /** Identificador del usuario que realizó el comentario */
    private int idUsuario;

    // Getters y Setters
    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
