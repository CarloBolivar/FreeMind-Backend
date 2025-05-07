package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CantidadComentarioDTO;
import pe.edu.upc.free_mind.dtos.CantidadSumaPagoDTO;
import pe.edu.upc.free_mind.dtos.UsuarioDTO;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.servicesinterfaces.IUsuarioService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Controlador REST para la gestión de usuarios
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    //Servicio de lógica de negocio para la entidad Usuario
    @Autowired
    private IUsuarioService usuarioService;

    //Lista todos los usuarios existentes
    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    //Registra un nuevo usuario
    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        usuarioService.insert(u);
    }

    //Elimina un usuario por su ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        usuarioService.delete(id);
    }

    //Obtiene un usuario por su ID
    @GetMapping("/{id}")
    public UsuarioDTO obtenerPorId(@PathVariable("id") Integer id) {
        Usuario u = usuarioService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(u, UsuarioDTO.class);
    }

    //Modifica un usuario existente
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        usuarioService.update(u);
    }

    //Obtiene el perfil del usuario autenticado
    @GetMapping("/perfil")
    public UsuarioDTO obtenerPerfil(@AuthenticationPrincipal UserDetails userDetails) {
        String correo = userDetails.getUsername();
        Usuario usuario = usuarioService.findByCorreo(correo);
        ModelMapper m = new ModelMapper();
        return m.map(usuario, UsuarioDTO.class);
    }

    //Reportes

    /*Renzo*/

    //Obtiene el monto total pagado por usuario
    @GetMapping("/montos")
    public List<CantidadSumaPagoDTO> sumaPago() {
        List<CantidadSumaPagoDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = usuarioService.amountByUsuario();
        for (String[] columna : fila) {
            CantidadSumaPagoDTO dto = new CantidadSumaPagoDTO();
            dto.setNombre(columna[0]);
            dto.setAmountByUsuario(Double.parseDouble(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    //Obtiene la cantidad de comentarios realizados por usuario
    @GetMapping("/comentarios")
    public List<CantidadComentarioDTO> cantidadComentario() {
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

    @GetMapping("/roles")
    public List<CantidadxRolesDTO> cantidadUsuario(){
        List<CantidadxRolesDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = usuarioService.cantByUsuario();
        for (String[] columna : fila) {
            CantidadxRolesDTO dto = new CantidadxRolesDTO();
            dto.setRol(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
