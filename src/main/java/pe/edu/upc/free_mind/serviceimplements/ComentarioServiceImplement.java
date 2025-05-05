package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.CantidadComentariosPorUsuarioDTO;
import pe.edu.upc.free_mind.entities.Comentario;
import pe.edu.upc.free_mind.repositories.IComentarioRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IComentarioService;

import java.util.List;

//Implementación del servicio para la entidad Comentario
@Service
public class ComentarioServiceImplement implements IComentarioService {

    //Repositorio para operaciones CRUD sobre Comentario
    @Autowired
    private IComentarioRepository cR;

    //Inserta un nuevo comentario en la base de datos
    @Override
    public void insert(Comentario comentario) {
        cR.save(comentario);
    }

    //Lista todos los comentarios registrados
    @Override
    public List<Comentario> list() {
        return cR.findAll();
    }

    //Elimina un comentario según su ID
    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    //Obtiene un comentario por su ID
    @Override
    public Comentario listId(int id) {
        return cR.findById(id).orElse(new Comentario());
    }

    //Actualiza un comentario existente
    @Override
    public void update(Comentario comentario) {
        cR.save(comentario);
    }

    //Reportes
    /*Mauricio*/
    @Override
    public List<CantidadComentariosPorUsuarioDTO> cantidadComentariosPorUsuario() {
        return cR.obtenerCantidadComentariosPorUsuario();
    }

    /*Deyci*/
    @Override
    public List<String[]> obtenerCantComentariosNegativosPorPsicologo() {
        return cR.obtenerCantComentariosNegativosPorPsicologo();
    }



}
