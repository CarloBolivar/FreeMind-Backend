package pe.edu.upc.free_mind.dtos;

//DTO que representa la cantidad de comentarios por usuario
public class CantidadComentariosPorUsuarioDTO {
    private String nombreUsuario;
    private long cantidadComentarios;

    public CantidadComentariosPorUsuarioDTO() {
    }

    public CantidadComentariosPorUsuarioDTO(String nombreUsuario, long cantidadComentarios) {
        this.nombreUsuario = nombreUsuario;
        this.cantidadComentarios = cantidadComentarios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public long getCantidadComentarios() {
        return cantidadComentarios;
    }

    public void setCantidadComentarios(long cantidadComentarios) {
        this.cantidadComentarios = cantidadComentarios;
    }
}
