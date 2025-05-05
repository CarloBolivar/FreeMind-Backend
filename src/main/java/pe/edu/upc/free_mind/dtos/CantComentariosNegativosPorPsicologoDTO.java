package pe.edu.upc.free_mind.dtos;

public class CantComentariosNegativosPorPsicologoDTO {
    //Nombre del psicólogo
    private String nombrePsicologo;

    //Cantidad de comentarios negativos con calificacion <=2 recibidos por un psicologo
    private int comentariosNegativos;

    //Getters y Setters
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
