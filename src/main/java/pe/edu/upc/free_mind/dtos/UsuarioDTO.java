package pe.edu.upc.free_mind.dtos;

import lombok.Data;

/**
 * DTO para la entidad Usuario.
 */
@Data
public class UsuarioDTO {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String dni;
    private String especialidad;
    private String credencial;
    private int idRol;
}
