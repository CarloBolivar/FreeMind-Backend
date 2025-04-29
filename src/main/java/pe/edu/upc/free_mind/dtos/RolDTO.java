package pe.edu.upc.free_mind.dtos;

//DTO para transferir datos de la entidad Rol
public class RolDTO {

    //Identificador del rol
    private int idRol;

    //Nombre del rol
    private String nombre;

    //Getters y Setters
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
