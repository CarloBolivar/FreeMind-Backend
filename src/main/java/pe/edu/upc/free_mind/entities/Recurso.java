package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa un recurso (imagen, música, video)
 * asociado a una terapia.
 */
@Entity
@Data
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecurso;

    @Column(length = 100, nullable = false)
    private String tipo;

    @Column(length = 1000, nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "idTerapia")
    private Terapia terapia;
}
