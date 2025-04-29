package pe.edu.upc.free_mind.dtos;

//DTO para representar el total de ingresos por psicólogo
public class TotalIngresosPorPsicologoDTO {

    //Nombre del psicólogo
    private String nombre;

    //Apellido del psicólogo
    private String apellido;

    //Total de ingresos generados
    private int totalIngresos;

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(int totalIngresos) {
        this.totalIngresos = totalIngresos;
    }
}
