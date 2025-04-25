package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Rol;
import pe.edu.upc.free_mind.repositories.IRolRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IRolService;

import java.util.List;

/**
 * Implementación de la interfaz IRolService.
 * Gestiona las operaciones lógicas relacionadas a la entidad Rol.
 */
@Service
public class RolServiceImplement implements IRolService {

    /** Repositorio que permite operaciones con la tabla Rol */
    @Autowired
    private IRolRepository rR;

    /**
     * Inserta un nuevo rol en la base de datos
     * @param rol Objeto Rol a guardar
     */
    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    /**
     * Lista todos los roles existentes en la base de datos
     * @return Lista de objetos Rol
     */
    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    /**
     * Elimina un rol dado su identificador
     * @param id ID del rol a eliminar
     */
    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    /**
     * Retorna un rol por su ID, o uno nuevo si no lo encuentra
     * @param id Identificador del rol
     * @return Objeto Rol correspondiente
     */
    @Override
    public Rol listId(int id) {
        return rR.findById(id).orElse(new Rol());
    }

    /**
     * Actualiza un rol existente
     * @param rol Objeto Rol con datos modificados
     */
    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }
}
