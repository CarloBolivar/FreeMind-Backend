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

    /** Típo del recurso */
    @Column(name = "tipo", nullable = false, length = 60)
    private String tipo;

    /** Descripción breve del recurso */
    @Column(name = "descripcion", length = 300)
    private String descripcion;

    /** Enlace o ruta del recurso */
    @Column(name = "enlace", nullable = false, length = 255)
    private String enlace;

    /** Relación con Tabla Terapia */
    @ManyToOne
    @JoinColumn(name = "idTerapia")
    private Terapia terapia;


    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Terapia getTerapia() {return terapia;}

    public void setTerapia(Terapia terapia) {this.terapia = terapia;}
}
