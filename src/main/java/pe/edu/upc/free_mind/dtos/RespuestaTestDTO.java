package pe.edu.upc.free_mind.dtos;

import lombok.Data;

/**
 * DTO para la entidad RespuestaTest.
 */
@Data
public class RespuestaTestDTO {
    private int idRespuesta;
    private String contenido;
    private int valor;
    private int idPregunta;
}
