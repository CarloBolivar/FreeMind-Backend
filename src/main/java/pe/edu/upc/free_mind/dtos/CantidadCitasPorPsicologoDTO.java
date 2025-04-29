package pe.edu.upc.free_mind.dtos;

//DTO para representar la cantidad de citas atendidas por psicólogo
public class CantidadCitasPorPsicologoDTO {

    //Nombre del psicólogo
    private String nombrePsicologo;

    //Cantidad de citas atendidas por el psicólogo
    private int cantidadCitas;

    //Getters y Setters
    public String getNombrePsicologo() {
        return nombrePsicologo;
    }

    public void setNombrePsicologo(String nombrePsicologo) {
        this.nombrePsicologo = nombrePsicologo;
    }

    public int getCantidadCitas() {
        return cantidadCitas;
    }

    public void setCantidadCitas(int cantidadCitas) {
        this.cantidadCitas = cantidadCitas;
    }
}
