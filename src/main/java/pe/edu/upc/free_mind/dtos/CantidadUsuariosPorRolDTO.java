package pe.edu.upc.free_mind.dtos;

//DTO para representar el total de usuarios por rol
public class CantidadUsuariosPorRolDTO {
    private String rol;
    private int cantidad;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
