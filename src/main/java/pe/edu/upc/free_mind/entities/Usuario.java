package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad Usuario que representa a pacientes y psicólogos registrados.
 */
@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido;

    @Column(length = 100, nullable = false, unique = true)
    private String correo;

    @Column(length = 100, nullable = false)
    private String contrasena;

    @Column(length = 8, nullable = false, unique = true)
    private String dni;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    @Column(length = 100)
    private String especialidad; // solo si es psicólogo

    @Column(length = 100)
    private String credencial; // solo si es psicólogo
}
