package pe.edu.upc.free_mind.dtos;

import lombok.Data;

/**
 * DTO para la entidad PreguntaTest.
 */
@Data
public class PreguntaTestDTO {
    private int idPregunta;
    private String contenido;
    private int idTest;
}
