package pe.edu.upc.free_mind.dtos;

import java.time.LocalDate;

/**
 * DTO para representar los datos de un test psicológico completado por un usuario.
 */
public class TestRealizadoDTO {

    /** Identificador único del test realizado */
    private int idTestRealizado;

    /** Fecha en la que se realizó el test */
    private LocalDate fecha;

    /** Resultado obtenido en el test */
    private String resultado;

    /** Identificador del usuario que realizó el test */
    private int idUsuario;

    /** Identificador del test que fue realizado */
    private int idTest;

    // Getters y Setters
    public int getIdTestRealizado() {
        return idTestRealizado;
    }

    public void setIdTestRealizado(int idTestRealizado) {
        this.idTestRealizado = idTestRealizado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }
}
