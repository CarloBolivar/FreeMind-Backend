package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

/**
 * Entidad que representa un test que puede ser respondido por los usuarios.
 */
@Entity
@Table(name = "test")
public class Test {

    /** Identificador único del test */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTest;

    /** Título del test */
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    /** Descripción general del test */
    @Column(name = "descripcion")
    private String descripcion;

    // Getters y Setters
    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
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
