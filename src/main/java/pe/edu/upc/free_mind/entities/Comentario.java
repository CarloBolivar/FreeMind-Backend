package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidad que representa un comentario realizado por un usuario.
 */
@Entity
@Table(name = "comentario")
public class Comentario {

    /** Identificador único del comentario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private int idComentario;

    /** Contenido del comentario */
    @Column(name = "comentario", nullable = false, length = 2000)
    private String comentario;

    /** Puntuación del comentario */
    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

    /** Fecha en que se realizó el comentario */
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    /** Usuario que realizó el comentario */
    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario", nullable = false)
    private Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
