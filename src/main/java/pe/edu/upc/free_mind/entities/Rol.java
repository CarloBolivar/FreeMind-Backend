package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

// Entidad que representa el rol que tiene un usuario dentro del sistema.
// Mapeada a la tabla "rol" en la base de datos.
@Entity
@Table(name = "rol")
public class Rol {

    // Identificador único del rol
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    // Nombre del rol (por ejemplo: ADMIN, PSICOLOGO, PACIENTE)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
