package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Entidad que representa un pago realizado por un usuario.
 */
@Entity
@Table(name = "pago")
public class Pago {

    /** Identificador único del pago */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    /** Fecha del pago realizado */
    @Column(name = "fechaPago", nullable = false)
    private LocalDate fechaPago;

    /** Monto del pago */
    @Column(name = "monto", nullable = false)
    private double monto;

    /** Método de pago utilizado (ej. tarjeta, efectivo) */
    @Column(name = "metodo", length = 50)
    private String metodo;

    /** Relación con el usuario que realiza el pago */
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
