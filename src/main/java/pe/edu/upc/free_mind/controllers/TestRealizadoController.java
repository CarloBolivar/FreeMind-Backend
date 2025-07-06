package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CantidadTestsPorMesDTO;
import pe.edu.upc.free_mind.dtos.TestRealizadoDTO;
import pe.edu.upc.free_mind.entities.TestRealizado;
import pe.edu.upc.free_mind.servicesinterfaces.ITestRealizadoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Controlador REST para gestionar tests realizados por usuarios
@RestController
@RequestMapping("/tests-realizados")
public class TestRealizadoController {

    //Servicio para operaciones sobre TestRealizado
    @Autowired
    private ITestRealizadoService testRealizadoService;

    //Lista todos los tests realizados
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @GetMapping
    public List<TestRealizadoDTO> listar() {
        return testRealizadoService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TestRealizadoDTO.class);
        }).collect(Collectors.toList());
    }

    //Registra un nuevo test realizado
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @PostMapping
    public void insertar(@RequestBody TestRealizadoDTO dto) {
        ModelMapper m = new ModelMapper();
        TestRealizado t = m.map(dto, TestRealizado.class);
        testRealizadoService.insert(t);
    }

    //Elimina un test realizado por su ID
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        testRealizadoService.delete(id);
    }

    //Obtiene un test realizado por su ID
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @GetMapping("/{id}")
    public TestRealizadoDTO obtenerPorId(@PathVariable("id") Integer id) {
        TestRealizado t = testRealizadoService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(t, TestRealizadoDTO.class);
    }

    //Modifica un test realizado existente
    @PreAuthorize("hasAnyAuthority('ADMIN', 'PSICOLOGO','PACIENTE')")
    @PutMapping
    public void modificar(@RequestBody TestRealizadoDTO dto) {
        ModelMapper m = new ModelMapper();
        TestRealizado t = m.map(dto, TestRealizado.class);
        testRealizadoService.update(t);
    }

    //Reportes

    /*Erick*/
    //Obtiene la cantidad de tests completados por mes
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/cantidad-tests-por-mes")
    public List<CantidadTestsPorMesDTO> obtenerCantidadTestsPorMes() {
        List<CantidadTestsPorMesDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = testRealizadoService.cantidadTestsPorMes();
        for (String[] columna : fila) {
            CantidadTestsPorMesDTO dto = new CantidadTestsPorMesDTO();
            dto.setMes(Integer.parseInt(columna[0]));
            dto.setCantidadTests(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
