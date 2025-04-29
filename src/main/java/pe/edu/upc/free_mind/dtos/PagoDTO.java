package pe.edu.upc.free_mind.dtos;

//DTO para transferir datos de la entidad Pago
public class PagoDTO {

    //Identificador único del pago
    private int idPago;

    //Número de la tarjeta utilizada para el pago
    private String numeroTarjeta;

    //Nombres del titular de la tarjeta
    private String nombres;

    //Apellidos del titular de la tarjeta
    private String apellidos;

    //Mes de vencimiento de la tarjeta
    private int mes;

    //Año de vencimiento de la tarjeta
    private int anio;

    //Código de verificación de la tarjeta (CVV)
    private int cvv;

    //Correo electrónico asociado al pago
    private String correo;

    //Identificador de la cita asociada al pago
    private int idCita;

    //Monto del pago
    private int monto;

    //Getters y Setters
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

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
