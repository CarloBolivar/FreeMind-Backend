package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa los roles disponibles en el sistema,
 * como "Paciente" o "Psicólogo".
 */
@Entity
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(length = 50, nullable = false)
    private String nombre;
}
