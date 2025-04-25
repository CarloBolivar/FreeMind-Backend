package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.UsuarioDTO;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.servicesinterfaces.IUsuarioService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para la gestión de usuarios.
 * Utiliza ModelMapper para la conversión entre entidades y DTOs.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    /**
     * Servicio de lógica de negocio para la entidad Usuario.
     */
    @Autowired
    private IUsuarioService usuarioService;

    /**
     * Lista todos los usuarios existentes.
     * Crea una instancia de ModelMapper dentro del método
     *
     * @return Lista de UsuarioDTO
     */
    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    /**
     * Registra un nuevo usuario.
     *
     * @param dto UsuarioDTO con los datos a registrar
     */
    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        usuarioService.insert(u);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id Identificador del usuario a eliminar
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        usuarioService.delete(id);
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id Identificador del usuario a consultar
     * @return UsuarioDTO del usuario encontrado
     */
    @GetMapping("/{id}")
    public UsuarioDTO obtenerPorId(@PathVariable("id") Integer id) {
        Usuario u = usuarioService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(u, UsuarioDTO.class);
    }

    /**
     * Modifica un usuario existente.
     *
     * @param dto UsuarioDTO con los datos actualizados
     */
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        usuarioService.update(u);
    }

    @GetMapping("/perfil")
    public UsuarioDTO obtenerPerfil(@AuthenticationPrincipal UserDetails userDetails) {
        String correo = userDetails.getUsername(); // viene desde el token JWT
        Usuario usuario = usuarioService.findByCorreo(correo); // necesitas tener este metodo en tu servicio
        ModelMapper m = new ModelMapper();
        return m.map(usuario, UsuarioDTO.class);
    }


    
    /*R*/
    @GetMapping("/montos")
    public List<SumaPagoDTO> sumaPago(){
        List<SumaPagoDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = usuarioService.amountByUsuario();
        for (String[] columna : fila) {
            SumaPagoDTO dto = new SumaPagoDTO();
            dto.setNombre(columna[0]);
            dto.setAmountByUsuario(Double.parseDouble(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/comentarios")
    public List<CantidadComentarioDTO> cantidadComentario(){
        List<CantidadComentarioDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = usuarioService.comentByUsuario();
        for (String[] columna : fila) {
            CantidadComentarioDTO dto = new CantidadComentarioDTO();
            dto.setNombre(columna[0]);
            dto.setComentByUsuario(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }



    
}


