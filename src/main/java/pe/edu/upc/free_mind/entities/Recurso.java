package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

// Entidad que representa un recurso educativo o informativo.
@Entity
@Table(name = "recurso")
public class Recurso {

    // Identificador único del recurso
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecurso;

    // Tipo del recurso (por ejemplo: video, documento, enlace)
    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;

    // URL del recurso
    @Column(name = "url", nullable = false, length = 500)
    private String url;

    // Relación con la entidad Terapia
    @ManyToOne
    @JoinColumn(name = "id_terapia", nullable = false)
    private Terapia terapia;

    public Recurso() {
    }

    // Getters y Setters
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Terapia getTerapia() {
        return terapia;
    }

    public void setTerapia(Terapia terapia) {
        this.terapia = terapia;
    }
}
