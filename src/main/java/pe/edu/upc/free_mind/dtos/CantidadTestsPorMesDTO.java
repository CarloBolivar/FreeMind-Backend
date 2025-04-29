package pe.edu.upc.free_mind.dtos;

//DTO que representa la cantidad de tests psicológicos completados por mes
public class CantidadTestsPorMesDTO {

    //Mes en que se completaron los tests
    private int mes;

    //Cantidad de tests completados
    private int cantidadTests;

    //Constructor vacío
    public CantidadTestsPorMesDTO() {
    }

    //Getters y Setters
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getCantidadTests() {
        return cantidadTests;
    }

    public void setCantidadTests(int cantidadTests) {
        this.cantidadTests = cantidadTests;
    }
}
