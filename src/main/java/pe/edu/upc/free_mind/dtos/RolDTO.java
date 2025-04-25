package pe.edu.upc.free_mind.dtos;

/**
 * DTO para la entidad Rol.
 * Representa un objeto de transferencia de datos para un rol del sistema.
 */
public class RolDTO {

    private int idRol;
    private String nombre;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
