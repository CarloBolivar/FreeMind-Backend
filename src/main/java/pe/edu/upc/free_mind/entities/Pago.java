package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

/**
 * Entidad que representa un pago realizado para una cita.
 */
@Entity
@Table(name = "pago")
public class Pago {

    /** Identificador único del pago */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    /** Número de la tarjeta utilizada para el pago */
    @Column(name = "numero_tarjeta", nullable = false, length = 20)
    private String numeroTarjeta;

    /** Nombres del titular de la tarjeta */
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    /** Apellidos del titular de la tarjeta */
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    /** Mes de vencimiento de la tarjeta */
    @Column(name = "mes", nullable = false)
    private int mes;

    /** Año de vencimiento de la tarjeta */
    @Column(name = "anio", nullable = false)
    private int anio;

    /** Código de verificación de la tarjeta (CVV) */
    @Column(name = "cvv", nullable = false)
    private int cvv;

    /** Correo electrónico asociado al pago */
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    /** Monto del pago */
    @Column(name = "monto", nullable = false)
    private int monto;

    /** Cita asociada al pago */
    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    // Getters y Setters
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}
