package pe.edu.upc.free_mind.dtos;

import lombok.Data;

/**
 * DTO para la entidad Cita.
 */
@Data
public class CitaDTO {
    private int idCita;
    private String fecha;
    private String hora;
    private int idPaciente;
    private int idPsicologo;
    private int idHorario;
    private int idTerapia;
}
