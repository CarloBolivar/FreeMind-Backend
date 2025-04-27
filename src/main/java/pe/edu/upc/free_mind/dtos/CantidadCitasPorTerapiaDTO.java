package pe.edu.upc.free_mind.dtos;

public class CantidadCitasPorTerapiaDTO {
    private String nameTerapia;
    private int quantityCitas;

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
}
