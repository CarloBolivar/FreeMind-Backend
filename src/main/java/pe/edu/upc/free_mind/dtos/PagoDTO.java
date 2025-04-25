package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.Usuario;
import java.time.LocalDate;

/**
 * DTO para transferir datos de la entidad Pago.
 */
public class PagoDTO {

    private int idPago;
    private LocalDate fechaPago;
    private double monto;
    private String metodo;
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
