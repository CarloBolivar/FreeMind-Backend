package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa una terapia configurada o sugerida para un paciente.
 */
@Entity
@Data
public class Terapia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTerapia;

    @Column(length = 200, nullable = false)
    private String nombre;

    @Column(length = 2000)
    private String descripcion;
}
