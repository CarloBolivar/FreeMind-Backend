package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa un test psicológico resuelto por un usuario.
 */
@Entity
@Data
public class TestRealizado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTestRealizado;

    @Column(length = 10, nullable = false)
    private String fecha;

    @Column(nullable = false)
    private int puntuacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idTest")
    private Test test;
}
