package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

/**
 * Entidad que representa un recurso educativo o informativo.
 */
@Entity
@Table(name = "recurso")
public class Recurso {

    /** Identificador único del recurso */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecurso;

    /** Título del recurso */
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    /** Descripción breve del recurso */
    @Column(name = "descripcion", length = 300)
    private String descripcion;

    /** Enlace o ruta del recurso */
    @Column(name = "enlace", nullable = false, length = 255)
    private String enlace;

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}
