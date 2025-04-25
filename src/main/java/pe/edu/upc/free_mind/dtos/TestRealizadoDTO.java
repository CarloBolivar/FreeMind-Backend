package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.Usuario;
import java.time.LocalDateTime;

/**
 * DTO para representar los datos de un test psicológico completado por un usuario.
 */
public class TestRealizadoDTO {

    private int idTestRealizado;
    private LocalDateTime fechaRealizacion;
    private String resultado;
    private Usuario usuario;

    public int getIdTestRealizado() {
        return idTestRealizado;
    }

    public void setIdTestRealizado(int idTestRealizado) {
        this.idTestRealizado = idTestRealizado;
    }

    public LocalDateTime getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDateTime fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
