package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

// Entidad que representa un tipo de terapia disponible en el sistema.
@Entity
@Table(name = "terapia")
public class Terapia {

    // Identificador único de la terapia
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTerapia;

    // Título o nombre de la terapia
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    // Descripción detallada de la terapia (opcional)
    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = true)
    private String descripcion;

    public Terapia() {
    }

    // Getters y Setters
    public int getIdTerapia() {
        return idTerapia;
    }

    public void setIdTerapia(int idTerapia) {
        this.idTerapia = idTerapia;
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
}
