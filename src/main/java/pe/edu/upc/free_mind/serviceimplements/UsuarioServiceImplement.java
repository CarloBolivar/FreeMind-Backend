package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.dtos.UsuarioDTO;
import pe.edu.upc.free_mind.entities.Rol;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.repositories.IRolRepository;
import pe.edu.upc.free_mind.repositories.IUsuarioRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio de usuario.
 */
@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public void insert(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setCorreo(dto.getCorreo());
        u.setDni(dto.getDni());
        u.setEspecialidad(dto.getEspecialidad());
        u.setCredencial(dto.getCredencial());
        Rol r = rolRepository.findById(dto.getIdRol()).orElse(new Rol());
        u.setRol(r);
        usuarioRepository.save(u);
    }

    @Override
    public List<UsuarioDTO> list() {
        return usuarioRepository.findAll().stream().map(u -> {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setIdUsuario(u.getIdUsuario());
            dto.setNombre(u.getNombre());
            dto.setApellido(u.getApellido());
            dto.setCorreo(u.getCorreo());
            dto.setDni(u.getDni());
            dto.setEspecialidad(u.getEspecialidad());
            dto.setCredencial(u.getCredencial());
            dto.setIdRol(u.getRol().getIdRol());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioDTO update(int id, UsuarioDTO dto) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));

        u.setNombre(dto.getNombre());
        u.setApellido(dto.getApellido());
        u.setCorreo(dto.getCorreo());
        u.setDni(dto.getDni());
        u.setEspecialidad(dto.getEspecialidad());
        u.setCredencial(dto.getCredencial());

        Rol r = rolRepository.findById(dto.getIdRol()).orElse(new Rol());
        u.setRol(r);

        Usuario actualizado = usuarioRepository.save(u);

        UsuarioDTO result = new UsuarioDTO();
        result.setIdUsuario(actualizado.getIdUsuario());
        result.setNombre(actualizado.getNombre());
        result.setApellido(actualizado.getApellido());
        result.setCorreo(actualizado.getCorreo());
        result.setDni(actualizado.getDni());
        result.setEspecialidad(actualizado.getEspecialidad());
        result.setCredencial(actualizado.getCredencial());
        result.setIdRol(actualizado.getRol().getIdRol());

        return result;
    }
}
