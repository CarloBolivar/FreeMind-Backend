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

    /** Nombre o título del test */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    /** Descripción general del test */
    @Column(name = "descripcion", length = 300)
    private String descripcion;

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
