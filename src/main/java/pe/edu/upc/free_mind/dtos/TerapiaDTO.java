package pe.edu.upc.free_mind.dtos;

/**
 * DTO para transferir datos de la entidad Terapia.
 */
public class TerapiaDTO {

    /** Identificador único de la terapia */
    private int idTerapia;

    /** Título o nombre de la terapia */
    private String titulo;

    /** Descripción detallada de la terapia */
    private String descripcion;

    // Getters y Setters
    public int getIdTerapia() {
        return idTerapia;
    }

    public void setIdTerapia(int idTerapia) {
        this.idTerapia = idTerapia;
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
