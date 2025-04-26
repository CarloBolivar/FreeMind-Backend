package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad que representa un test psicológico que ha sido respondido por un usuario.
 */
@Entity
@Table(name = "test_realizado")
public class TestRealizado {

    /**
     * Identificador único del test realizado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTestRealizado;

    /**
     * Fecha y hora en que se completó el test
     */
    @Column(name = "fechaRealizacion", nullable = false)
    private LocalDateTime fechaRealizacion;

    /**
     * Resultado del test
     */
    @Column(name = "resultado", length = 300)
    private String resultado;

    /**
     * Usuario que realizó el test
     */
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idTest")
    private Test test;

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

    public Test getTest() { return test;}

    public void setTest(Test test) { this.test = test;}
}
