package pe.edu.upc.free_mind.dtos;

public class CantComentariosNegativosPorPsicologoDTO {

    private String nombrePsicologo;

    private int comentariosNegativos;

    public String getNombrePsicologo() {
        return nombrePsicologo;
    }

    public void setNombrePsicologo(String nombrePsicologo) {
        this.nombrePsicologo = nombrePsicologo;
    }

    public int getComentariosNegativos() {
        return comentariosNegativos;
    }

    public void setComentariosNegativos(int comentariosNegativos) {
        this.comentariosNegativos = comentariosNegativos;
    }
}
