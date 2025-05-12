package pe.edu.upc.free_mind.dtos;

public class CantidadPsicologosActivosDTO {

    //id usuario
    private int idPsicologo;

    //Nombre completo
    private String nombreCompleto;

    // especialidad
    private String Especialidad;

    public int getIdPsicologo() {
        return idPsicologo;
    }

    public void setIdPsicologo(int idPsicologo) {
        this.idPsicologo = idPsicologo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }



}
