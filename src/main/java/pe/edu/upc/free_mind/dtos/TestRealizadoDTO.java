package pe.edu.upc.free_mind.dtos;

import lombok.Data;

/**
 * DTO para la entidad TestRealizado.
 */
@Data
public class TestRealizadoDTO {
    private int idTestRealizado;
    private String fecha;
    private int puntuacion;
    private int idUsuario;
    private int idTest;
}
