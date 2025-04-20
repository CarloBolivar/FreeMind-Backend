package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.RolDTO;
import pe.edu.upc.free_mind.entities.Rol;
import pe.edu.upc.free_mind.repositories.IRolRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación de los métodos del servicio de Rol.
 */
@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public void insert(RolDTO dto) {
        Rol r = new Rol();
        r.setNombre(dto.getNombre());
        rolRepository.save(r);
    }

    @Override
    public List<RolDTO> list() {
        return rolRepository.findAll().stream().map(r -> {
            RolDTO dto = new RolDTO();
            dto.setIdRol(r.getIdRol());
            dto.setNombre(r.getNombre());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int idRol) {
        rolRepository.deleteById(idRol);
    }

    @Override
    public RolDTO update(int id, RolDTO dto) {
        Rol r = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));
        r.setNombre(dto.getNombre());
        Rol actualizado = rolRepository.save(r);
        RolDTO dtoResult = new RolDTO();
        dtoResult.setIdRol(actualizado.getIdRol());
        dtoResult.setNombre(actualizado.getNombre());
        return dtoResult;
    }
}
