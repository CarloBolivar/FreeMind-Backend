package pe.edu.upc.free_mind.dtos;

import lombok.Data;

/**
 * DTO para la entidad Comentario.
 */
@Data
public class ComentarioDTO {
    private int idComentario;
    private String comentario;
    private int puntuacion;
    private String fecha;
    private int idPaciente;
    private int idPsicologo;
}
