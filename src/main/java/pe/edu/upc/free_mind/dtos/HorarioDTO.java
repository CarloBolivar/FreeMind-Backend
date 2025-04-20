package pe.edu.upc.free_mind.dtos;

import lombok.Data;

/**
 * DTO para la entidad Horario.
 */
@Data
public class HorarioDTO {
    private int idHorario;
    private String dia;
    private String horaInicio;
    private String horaFin;
}
