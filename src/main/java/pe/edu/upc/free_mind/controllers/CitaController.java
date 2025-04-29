package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CantidadCitasPorTerapiaDTO;
import pe.edu.upc.free_mind.dtos.CitaDTO;
import pe.edu.upc.free_mind.dtos.TotalIngresosPorPsicologoDTO;
import pe.edu.upc.free_mind.entities.Cita;
import pe.edu.upc.free_mind.servicesinterfaces.ICitaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para la entidad Cita.
 * Expone endpoints para gestionar citas entre usuarios.
 */
@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    /**
     * Lista todas las citas existentes
     * @return Lista de CitaDTO
     */
    @GetMapping
    public List<CitaDTO> listar() {
        return citaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CitaDTO.class);
        }).collect(Collectors.toList());
    }

    /**
     * Registra una nueva cita
     * @param dto Objeto DTO recibido del cliente
     */
    @PostMapping
    public void insertar(@RequestBody CitaDTO dto) {
        ModelMapper m = new ModelMapper();
        Cita c = m.map(dto, Cita.class);
        citaService.insert(c);
    }

    /**
     * Elimina una cita por su ID
     * @param id Identificador de la cita
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        citaService.delete(id);
    }

    /**
     * Obtiene una cita por ID
     * @param id ID buscado
     * @return Objeto DTO de la cita encontrada
     */
    @GetMapping("/{id}")
    public CitaDTO obtenerPorId(@PathVariable("id") Integer id) {
        Cita c = citaService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(c, CitaDTO.class);
    }

    /**
     * Modifica una cita existente
     * @param dto Objeto con los datos actualizados
     */
    @PutMapping
    public void modificar(@RequestBody CitaDTO dto) {
        ModelMapper m = new ModelMapper();
        Cita c = m.map(dto, Cita.class);
        citaService.update(c);
    }

    /**
     * Reportes
     */
    /*Carlo*/
    @GetMapping("/cantidad-citas-por-psicologo")
    public List<String[]> obtenerCantidadCitasPorPsicologo() {
        return citaService.obtenerCantidadCitasPorPsicologo();
    }

    /*Deyci*/
    @GetMapping("/cantidadCitasxTerapia")
    public List<CantidadCitasPorTerapiaDTO> listCantidadCitasByTerapia() {
        List<CantidadCitasPorTerapiaDTO> dtoLista=new ArrayList<>();
        List<String[]> fila=citaService.QuantityCitaByTerapia();
        for(String[] columna:fila) {
            CantidadCitasPorTerapiaDTO dto=new CantidadCitasPorTerapiaDTO();
            dto.setNameTerapia(columna[0]);
            dto.setQuantityCitas(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/totalIngresosPsicologos")
    public List<TotalIngresosPorPsicologoDTO> listTotalIngresosPorPsicologo() {
        List<TotalIngresosPorPsicologoDTO> dtoLista=new ArrayList<>();
        List<String[]> fila=citaService.totalIngresosPorPsicologo();
        for(String[] columna:fila) {
            TotalIngresosPorPsicologoDTO dto=new TotalIngresosPorPsicologoDTO();
            dto.setNombre(columna[0]);
            dto.setApellido(columna[1]);
            dto.setTotalIngresos(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }



}
