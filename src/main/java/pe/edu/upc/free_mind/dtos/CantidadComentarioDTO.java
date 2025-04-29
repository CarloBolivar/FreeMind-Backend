package pe.edu.upc.free_mind.dtos;

//DTO que representa la cantidad de comentarios realizados por usuario
public class CantidadComentarioDTO {

    //Nombre del usuario
    private String nombre;

    //Cantidad de comentarios hechos por el usuario
    private int comentByUsuario;

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getComentByUsuario() {
        return comentByUsuario;
    }

    public void setComentByUsuario(int comentByUsuario) {
        this.comentByUsuario = comentByUsuario;
    }
}
