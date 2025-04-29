package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Rol;
import pe.edu.upc.free_mind.repositories.IRolRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IRolService;

import java.util.List;

//Implementación del servicio para la entidad Rol
@Service
public class RolServiceImplement implements IRolService {

    //Repositorio para operaciones CRUD sobre Rol
    @Autowired
    private IRolRepository rR;

    //Inserta un nuevo rol en la base de datos
    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    //Lista todos los roles registrados
    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    //Elimina un rol según su ID
    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    //Obtiene un rol por su ID
    @Override
    public Rol listId(int id) {
        return rR.findById(id).orElse(new Rol());
    }

    //Actualiza un rol existente
    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }
}
