package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CantidadPsicologosActivosDTO;
import pe.edu.upc.free_mind.dtos.CantidadSumaPagoDTO;
import pe.edu.upc.free_mind.dtos.CantidadUsuariosPorRolDTO;
import pe.edu.upc.free_mind.dtos.UsuarioDTO;
import pe.edu.upc.free_mind.entities.Usuario;
import pe.edu.upc.free_mind.servicesinterfaces.IUsuarioService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import pe.edu.upc.free_mind.dtos.UsuarioSeguroDTO;

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
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<UsuarioSeguroDTO> listar() {
        return usuarioService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioSeguroDTO.class);
        }).collect(Collectors.toList());
    }

    //Registra un nuevo usuario
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        usuarioService.insert(u);
    }

    //Elimina un usuario por su ID
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        usuarioService.delete(id);
    }

    //Obtiene un usuario por su ID
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public UsuarioSeguroDTO obtenerPorId(@PathVariable("id") Integer id) {
        Usuario u = usuarioService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(u, UsuarioSeguroDTO.class);
    }

    //Modifica un usuario existente
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        usuarioService.update(u);
    }

    //Obtiene el perfil del usuario autenticado
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/perfil")
    public UsuarioDTO obtenerPerfil(@AuthenticationPrincipal UserDetails userDetails) {
        String correo = userDetails.getUsername();
        Usuario usuario = usuarioService.findByCorreo(correo);
        ModelMapper m = new ModelMapper();
        return m.map(usuario, UsuarioDTO.class);
    }

    //Reportes

    /* Ariam */
    //Número de psicólogos activos
    @GetMapping(  "/psicologos-activos")
    public List<CantidadPsicologosActivosDTO> obtenerPsicologosActivos() {

        List<CantidadPsicologosActivosDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = usuarioService.getPsicologosActivos();
        for (String[] columna : fila) {
            CantidadPsicologosActivosDTO dto = new CantidadPsicologosActivosDTO();
            dto.setIdPsicologo(Integer.parseInt(columna[0]));
            dto.setNombreCompleto(columna[1]);
            dto.setEspecialidad(columna[2]);
            dtoLista.add(dto);
        }
        return dtoLista;

    }

    /*Renzo*/
    //Obtiene el monto total pagado por usuario
    @PreAuthorize("hasAuthority('ADMIN')")
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

    //Obtiene el monto total de usuarios por roles
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/roles")
    public List<CantidadUsuariosPorRolDTO> cantidadUsuario(){
        List<CantidadUsuariosPorRolDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = usuarioService.cantByUsuario();
        for (String[] columna : fila) {
            CantidadUsuariosPorRolDTO dto = new CantidadUsuariosPorRolDTO();
            dto.setRol(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    //Filtro
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/filtro")
    public List<UsuarioSeguroDTO> filtrarUsuarios(
            @RequestParam(required = false) String especialidad,
            @RequestParam(required = false) Integer idRol) {

        List<Usuario> usuarios = usuarioService.filtrarUsuarios(especialidad, idRol);
        ModelMapper mapper = new ModelMapper();
        return usuarios.stream()
                .map(u -> mapper.map(u, UsuarioSeguroDTO.class))
                .collect(Collectors.toList());
    }
}
