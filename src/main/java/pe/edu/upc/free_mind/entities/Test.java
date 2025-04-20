package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa un test psicológico disponible en la aplicación.
 */
@Entity
@Data
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTest;

    @Column(length = 200, nullable = false)
    private String nombre;

    @Column(length = 1000)
    private String descripcion;
}
