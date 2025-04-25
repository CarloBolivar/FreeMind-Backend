package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;

/**
 * Entidad que representa a un usuario en el sistema.
 * Mapeada a la tabla "usuario" en la base de datos.
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    /** Identificador único del usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    /** Nombre del usuario */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    /** Apellido del usuario */
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    /** Correo electrónico del usuario */
    @Column(name = "correo", nullable = false, length = 150)
    private String correo;

    /** Contraseña cifrada del usuario */
    @Column(name = "contrasena", nullable = false, length = 100)
    private String contrasena;

    /** Documento Nacional de Identidad */
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    /** Especialidad del usuario (si aplica) */
    @Column(name = "especialidad", length = 100)
    private String especialidad;

    /** Número o código de credencial profesional */
    @Column(name = "credencial", length = 50)
    private String credencial;

    @Column(name = "enabled")
    private Boolean enabled = true;


    /** Rol que tiene el usuario dentro del sistema */
    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    /** Resultado del test asociado al usuario */
    @ManyToOne
    @JoinColumn(name = "idRespuesta")
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
