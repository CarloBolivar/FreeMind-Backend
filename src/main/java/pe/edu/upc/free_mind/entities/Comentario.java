package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Entidad que representa un comentario realizado por un usuario en relación a una cita, terapia u otro recurso.
 */
@Entity
@Table(name = "comentario")
public class Comentario {

    /** Identificador único del comentario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;

    /** Contenido del comentario */
    @Column(name = "contenido", nullable = false, length = 500)
    private String contenido;

    /** Fecha y hora en la que se hizo el comentario */
    @Column(name = "fechaComentario", nullable = false)
    private LocalDateTime fechaComentario;

    /** Relación con el usuario que comenta */
    @ManyToOne
    @JoinColumn(name = "idUsuario")
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
