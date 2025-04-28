package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.TerapiaDTO;
import pe.edu.upc.free_mind.entities.Terapia;
import pe.edu.upc.free_mind.dtos.MontoPorTipoDeTerapiaDTO;
import pe.edu.upc.free_mind.servicesinterfaces.ITerapiaService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para la entidad Terapia.
 * Expone endpoints para operaciones CRUD de terapias realizadas o programadas.
 */
@RestController
@RequestMapping("/terapias")
public class TerapiaController {

    @Autowired
    private ITerapiaService terapiaService;

    /**
     * Lista todas las terapias registradas
     * @return Lista de TerapiaDTO
     */
    @GetMapping
    public List<TerapiaDTO> listar() {
        return terapiaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TerapiaDTO.class);
        }).collect(Collectors.toList());
    }

     //@GetMapping("/monto-por-tipo")
     //public List<MontoPorTipoDeTerapiaDTO> obtenerMontoTotalPorTipoTerapia() {
     //return tS.listarMontosPorTipoTerapia();
    //}



    
    /**
     * Inserta una nueva terapia
     * @param dto DTO recibido del cliente
     */
    @PostMapping
    public void insertar(@RequestBody TerapiaDTO dto) {
        ModelMapper m = new ModelMapper();
        Terapia t = m.map(dto, Terapia.class);
        terapiaService.insert(t);
    }

    /**
     * Elimina una terapia por su ID
     * @param id ID de la terapia
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        terapiaService.delete(id);
    }

    /**
     * Obtiene una terapia específica por ID
     * @param id ID buscado
     * @return DTO de la terapia encontrada
     */
    @GetMapping("/{id}")
    public TerapiaDTO obtenerPorId(@PathVariable("id") Integer id) {
        Terapia t = terapiaService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(t, TerapiaDTO.class);
    }

    /**
     * Modifica una terapia existente
     * @param dto DTO con los datos actualizados
     */
    @PutMapping
    public void modificar(@RequestBody TerapiaDTO dto) {
        ModelMapper m = new ModelMapper();
        Terapia t = m.map(dto, Terapia.class);
        terapiaService.update(t);
    }
}
