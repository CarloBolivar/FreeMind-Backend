package pe.edu.upc.free_mind.dtos;

/**
 * DTO para la entidad Usuario.
 * Contiene los campos necesarios para transferir datos entre capas de presentación y lógica.
 * Este DTO sigue el estilo de la demo3155API.
 */
public class UsuarioDTO {

    /** Identificador del usuario */
    private int idUsuario;

    /** Nombre del usuario */
    private String nombre;

    /** Apellido del usuario */
    private String apellido;

    /** Correo electrónico del usuario */
    private String correo;

    /** Contraseña de acceso al sistema */
    private String contrasena;

    /** Documento Nacional de Identidad */
    private String dni;

    /** Especialidad del usuario (por ejemplo, psicología, medicina, etc.) */
    private String especialidad;

    /** Número de credencial profesional */
    private String credencial;

    /** Identificador del rol asociado al usuario */
    private int idRol;

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
}
