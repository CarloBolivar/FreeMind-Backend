package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CantidadComentariosNegativosPorPsicologoDTO;
import pe.edu.upc.free_mind.dtos.CantidadComentariosPorUsuarioDTO;
import pe.edu.upc.free_mind.dtos.ComentarioDTO;
import pe.edu.upc.free_mind.entities.Comentario;
import pe.edu.upc.free_mind.servicesinterfaces.IComentarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Controlador REST para gestionar operaciones sobre comentarios
@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    //Servicio para operaciones sobre Comentario
    @Autowired
    private IComentarioService comentarioService;

    //Lista todos los comentarios
    @GetMapping
    public List<ComentarioDTO> listar() {
        return comentarioService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ComentarioDTO.class);
        }).collect(Collectors.toList());
    }

    //Registra un nuevo comentario
    @PostMapping
    public void insertar(@RequestBody ComentarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Comentario c = m.map(dto, Comentario.class);
        comentarioService.insert(c);
    }

    //Elimina un comentario por su ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        comentarioService.delete(id);
    }

    //Obtiene un comentario por su ID
    @GetMapping("/{id}")
    public ComentarioDTO obtenerPorId(@PathVariable("id") Integer id) {
        Comentario c = comentarioService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(c, ComentarioDTO.class);
    }

    //Modifica un comentario existente
    @PutMapping
    public void modificar(@RequestBody ComentarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Comentario c = m.map(dto, Comentario.class);
        comentarioService.update(c);
    }

    //Reportes
    /*Mauricio*/
    @GetMapping("/cantidad-comentarios-por-usuario")
    public List<CantidadComentariosPorUsuarioDTO> cantidadComentariosPorUsuario() {
        return comentarioService.cantidadComentariosPorUsuario();
    }

    /*Deyci*/

    //Obtiene la cantidad de comentarios negativos de un psicologo
    // en base a las puntuaciones recibidas por los usuarios
    @GetMapping("/cantComentariosNegativosPorPsicologo")
    public List<CantidadComentariosNegativosPorPsicologoDTO> cantidadComentariosNegativosPorPsicologo() {
        List<CantidadComentariosNegativosPorPsicologoDTO> dtoLista = new ArrayList<>();
        List<String[]> fila= comentarioService.obtenerCantComentariosNegativosPorPsicologo();
        for (String[] columna : fila) {
            CantidadComentariosNegativosPorPsicologoDTO dto=new CantidadComentariosNegativosPorPsicologoDTO();
            dto.setNombrePsicologo(columna[0]);
            dto.setComentariosNegativos(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
