package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.RespuestaTest;
import pe.edu.upc.free_mind.entities.Rol;

/**
 * DTO para la entidad Usuario.
 * Contiene los campos necesarios para transferir datos entre capas de presentación y lógica.
 * Este DTO replica el estilo de la demo3155API, con relaciones representadas como objetos.
 */
public class UsuarioDTO {

    // Identificador del usuario
    private int idUsuario;

    // Nombre del usuario
    private String nombre;

    // Apellido del usuario
    private String apellido;

    // Correo electrónico del usuario
    private String correo;

    // Contraseña para acceso al sistema
    private String contrasena;

    // Documento Nacional de Identidad
    private String dni;

    // Especialidad del usuario (por ejemplo, psicología, medicina, etc.)
    private String especialidad;

    // Número o código de credencial profesional
    private String credencial;

    // Rol del usuario (relación con entidad Rol)
    private Rol rol;

    // Resultado del test de ingreso o validación (relación con entidad RespuestaTest)
    private RespuestaTest respuestaTest;

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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public RespuestaTest getRespuestaTest() {
        return respuestaTest;
    }

    public void setRespuestaTest(RespuestaTest respuestaTest) {
        this.respuestaTest = respuestaTest;
    }
}
