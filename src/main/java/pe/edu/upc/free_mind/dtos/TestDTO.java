package pe.edu.upc.free_mind.dtos;

/**
 * DTO para transferir datos de la entidad Test.
 */
public class TestDTO {

    /** Identificador único del test */
    private int idTest;

    /** Título del test */
    private String titulo;

    /** Descripción del test */
    private String descripcion;

    // Getters y Setters
    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
