package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.CantidadRecursosPorTerapiaDTO;
import pe.edu.upc.free_mind.entities.Recurso;
import pe.edu.upc.free_mind.repositories.IRecursoRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IRecursoService;

import java.util.List;

//Implementación del servicio para la entidad Recurso
@Service
public class RecursoServiceImplement implements IRecursoService {

    //Repositorio para operaciones CRUD sobre Recurso
    @Autowired
    private IRecursoRepository rR;

    //Inserta un nuevo recurso en la base de datos
    @Override
    public void insert(Recurso recurso) {
        rR.save(recurso);
    }

    //Lista todos los recursos registrados
    @Override
    public List<Recurso> list() {
        return rR.findAll();
    }

    //Elimina un recurso según su ID
    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    //Obtiene un recurso por su ID
    @Override
    public Recurso listId(int id) {
        return rR.findById(id).orElse(new Recurso());
    }

    //Actualiza un recurso existente
    @Override
    public void update(Recurso recurso) {
        rR.save(recurso);
    }

    //Reportes
    /*Mauricio*/
    @Override
    public List<CantidadRecursosPorTerapiaDTO> cantidadRecursosPorTerapia() {
        return rR.obtenerCantidadRecursosPorTerapia();
    }

}
