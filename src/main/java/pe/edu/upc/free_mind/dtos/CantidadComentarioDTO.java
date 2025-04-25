package pe.edu.upc.free_mind.dtos;

public class CantidadComentarioDTO {
    private String nombre;
    private int comentByUsuario;

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