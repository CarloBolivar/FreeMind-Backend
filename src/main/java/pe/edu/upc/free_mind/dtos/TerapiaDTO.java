package pe.edu.upc.free_mind.dtos;

import lombok.Data;

/**
 * DTO para la entidad Terapia.
 */
@Data
public class TerapiaDTO {
    private int idTerapia;
    private String nombre;
    private String descripcion;
}
