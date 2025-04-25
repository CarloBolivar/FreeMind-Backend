package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.Usuario;

import java.time.LocalDateTime;

/**
 * DTO para transferir datos relacionados a comentarios realizados por usuarios.
 */
public class ComentarioDTO {

    private int idComentario;
    private String contenido;
    private LocalDateTime fechaComentario;
    private Usuario usuario;

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDateTime fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
