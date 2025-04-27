package pe.edu.upc.free_mind.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidad que representa un test psicológico que ha sido respondido por un usuario.
 */
@Entity
@Table(name = "test_realizado")
public class TestRealizado {

    /** Identificador único del test realizado */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTestRealizado;

    /** Fecha en la que se completó el test */
    @Column(name = "fecha", nullable = false) // Se llama fecha, no fechaRealizacion
    private LocalDate fecha;

    /** Resultado del test */
    @Column(name = "resultado", columnDefinition = "text") // No poner length, usar definición text
    private String resultado;

    /** Usuario que realizó el test */
    @ManyToOne
    @JoinColumn(name = "id_usuario") // Nombre exacto en BD: id_usuario
    private Usuario usuario;

    /** Test que fue realizado */
    @ManyToOne
    @JoinColumn(name = "id_test") // Nombre exacto en BD: id_test
    private Test test;

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
