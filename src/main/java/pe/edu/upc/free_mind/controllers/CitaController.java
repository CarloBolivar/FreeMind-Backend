package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CantidadCitasPorPsicologoDTO;
import pe.edu.upc.free_mind.dtos.CantidadCitasPorTerapiaDTO;
import pe.edu.upc.free_mind.dtos.CitaDTO;
import pe.edu.upc.free_mind.dtos.CantidadTotalIngresosPorPsicologoDTO;
import pe.edu.upc.free_mind.entities.Cita;
import pe.edu.upc.free_mind.servicesinterfaces.ICitaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Controlador REST para gestionar citas entre usuarios
@RestController
@RequestMapping("/citas")
public class CitaController {

    //Servicio para operaciones sobre Cita
    @Autowired
    private ICitaService citaService;

    //Lista todas las citas existentes
    @GetMapping
    public List<CitaDTO> listar() {
        return citaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CitaDTO.class);
        }).collect(Collectors.toList());
    }

    //Registra una nueva cita
    @PostMapping
    public void insertar(@RequestBody CitaDTO dto) {
        ModelMapper m = new ModelMapper();
        Cita c = m.map(dto, Cita.class);
        citaService.insert(c);
    }

    //Elimina una cita por su ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        citaService.delete(id);
    }

    //Obtiene una cita por su ID
    @GetMapping("/{id}")
    public CitaDTO obtenerPorId(@PathVariable("id") Integer id) {
        Cita c = citaService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(c, CitaDTO.class);
    }

    //Modifica una cita existente
    @PutMapping
    public void modificar(@RequestBody CitaDTO dto) {
        ModelMapper m = new ModelMapper();
        Cita c = m.map(dto, Cita.class);
        citaService.update(c);
    }

    //Reportes

    /*Carlo*/

    //Obtiene la cantidad de citas atendidas por cada psicólogo
    @GetMapping("/cantidad-citas-por-psicologo")
    public List<CantidadCitasPorPsicologoDTO> obtenerCantidadCitasPorPsicologo() {
        List<CantidadCitasPorPsicologoDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = citaService.obtenerCantidadCitasPorPsicologo();
        for (String[] columna : fila) {
            CantidadCitasPorPsicologoDTO dto = new CantidadCitasPorPsicologoDTO();
            dto.setNombrePsicologo(columna[0]);
            dto.setCantidadCitas(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    /*Deyci*/

    //Obtiene la cantidad de citas por tipo de terapia
    @GetMapping("/cantidadCitasPorTerapia")
    public List<CantidadCitasPorTerapiaDTO> obtenerCantidadCitasPorTerapia() {
        List<CantidadCitasPorTerapiaDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = citaService.obtenerCantidadCitasPorTerapia();
        for (String[] columna : fila) {
            CantidadCitasPorTerapiaDTO dto = new CantidadCitasPorTerapiaDTO();
            dto.setNameTerapia(columna[0]);
            dto.setQuantityCitas(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    //Obtiene el total de ingresos por psicólogo
    @GetMapping("/totalIngresosPsicologos")
    public List<CantidadTotalIngresosPorPsicologoDTO> obtenerTotalIngresosPorPsicologo() {
        List<CantidadTotalIngresosPorPsicologoDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = citaService.totalIngresosPorPsicologo();
        for (String[] columna : fila) {
            CantidadTotalIngresosPorPsicologoDTO dto = new CantidadTotalIngresosPorPsicologoDTO();
            dto.setNombre(columna[0]);
            dto.setApellido(columna[1]);
            dto.setTotalIngresos(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
