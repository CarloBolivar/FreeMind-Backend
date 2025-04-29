package pe.edu.upc.free_mind.securities;

import java.io.Serializable;

//Clase que representa la solicitud de autenticación JWT
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    //Correo del usuario
    private String correo;

    //Contraseña del usuario
    private String contrasena;

    //Constructor vacío
    public JwtRequest() {
    }

    //Constructor con parámetros
    public JwtRequest(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    //Obtiene el correo
    public String getCorreo() {
        return correo;
    }

    //Establece el correo
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //Obtiene la contraseña
    public String getContrasena() {
        return contrasena;
    }

    //Establece la contraseña
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
