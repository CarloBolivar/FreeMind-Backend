package pe.edu.upc.free_mind.securities;

import java.io.Serializable;

//Clase que representa la respuesta JWT después de la autenticación
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    //Token generado
    private final String token;

    //Constructor que recibe el token
    public JwtResponse(String token) {
        this.token = token;
    }

    //Devuelve el token
    public String getToken() {
        return token;
    }
}
