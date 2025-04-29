package pe.edu.upc.free_mind.dtos;

//DTO para representar el monto total pagado por usuario
public class SumaPagoDTO {

    //Nombre del usuario
    private String nombre;

    //Monto total pagado por el usuario
    private Double amountByUsuario;

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getAmountByUsuario() {
        return amountByUsuario;
    }

    public void setAmountByUsuario(Double amountByUsuario) {
        this.amountByUsuario = amountByUsuario;
    }
}
