package pe.edu.upc.free_mind.dtos;

/**
 * DTO para transferir datos de la entidad Test.
 */
public class TestDTO {

    private int idTest;
    private String nombre;
    private String descripcion;

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
