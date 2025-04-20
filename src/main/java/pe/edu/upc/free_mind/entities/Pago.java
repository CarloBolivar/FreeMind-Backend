package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa el pago asociado a una cita médica.
 */
@Entity
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    @Column(nullable = false)
    private double monto;

    @Column(length = 20, nullable = false)
    private String metodo;

    @Column(length = 10, nullable = false)
    private String fecha;

    @OneToOne
    @JoinColumn(name = "idCita", unique = true)
    private Cita cita;
}
