package pe.edu.upc.free_mind.dtos;

import pe.edu.upc.free_mind.entities.Test;
import pe.edu.upc.free_mind.entities.Usuario;

import java.time.LocalDate;

//DTO para representar los datos de un test psicológico completado
public class TestRealizadoDTO {

    //Identificador único del test realizado
    private int idTestRealizado;

    //Fecha en la que se realizó el test
    private LocalDate fecha;

    //Resultado obtenido en el test
    private String resultado;

    //Identificador del usuario que realizó el test
    private Usuario usuario;

    //Identificador del test que fue realizado
    private Test test;

    //Getters y Setters

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
