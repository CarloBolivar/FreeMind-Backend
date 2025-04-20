package pe.edu.upc.free_mind.dtos;

import lombok.Data;

/**
 * DTO para la entidad Recurso.
 */
@Data
public class RecursoDTO {
    private int idRecurso;
    private String tipo;
    private String url;
    private int idTerapia;
}
