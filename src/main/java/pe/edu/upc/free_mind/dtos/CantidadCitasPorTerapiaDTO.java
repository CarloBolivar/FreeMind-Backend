package pe.edu.upc.free_mind.dtos;

//DTO que representa la cantidad de citas asociadas a cada tipo de terapia
public class CantidadCitasPorTerapiaDTO {

    //Nombre de la terapia
    private String nameTerapia;

    //descripcion de la terapia
    private String descripcion;

    //Cantidad de citas asociadas a la terapia
    private int quantityCitas;

    //Getters y Setters
    public String getNameTerapia() {
        return nameTerapia;
    }

    public void setNameTerapia(String nameTerapia) {
        this.nameTerapia = nameTerapia;
    }

    public int getQuantityCitas() {
        return quantityCitas;
    }

    public void setQuantityCitas(int quantityCitas) {
        this.quantityCitas = quantityCitas;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
