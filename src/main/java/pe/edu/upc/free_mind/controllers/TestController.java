package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CantidadTestsPorMesDTO;
import pe.edu.upc.free_mind.dtos.TestDTO;
import pe.edu.upc.free_mind.entities.Test;
import pe.edu.upc.free_mind.servicesinterfaces.ITestService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Controlador REST para gestionar la creación y consulta de tests
@RestController
@RequestMapping("/tests")
public class TestController {

    //Servicio para operaciones sobre Test
    @Autowired
    private ITestService testService;

    //Lista todos los tests registrados
    @GetMapping
    public List<TestDTO> listar() {
        return testService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TestDTO.class);
        }).collect(Collectors.toList());
    }

    //Inserta un nuevo test en la base de datos
    @PostMapping
    public void insertar(@RequestBody TestDTO dto) {
        ModelMapper m = new ModelMapper();
        Test t = m.map(dto, Test.class);
        testService.insert(t);
    }

    //Elimina un test por su ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        testService.delete(id);
    }

    //Obtiene un test específico por su ID
    @GetMapping("/{id}")
    public TestDTO obtenerPorId(@PathVariable("id") Integer id) {
        Test t = testService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(t, TestDTO.class);
    }

    //Modifica un test existente
    @PutMapping
    public void modificar(@RequestBody TestDTO dto) {
        ModelMapper m = new ModelMapper();
        Test t = m.map(dto, Test.class);
        testService.update(t);
    }

    //Reportes

    /*Erick*/
    //Obtiene la cantidad de tests completados por mes
    @GetMapping("/cantidad-tests-por-mes")
    public List<CantidadTestsPorMesDTO> obtenerCantidadTestsPorMes() {
        List<CantidadTestsPorMesDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = testService.cantidadTestsPorMes();
        for (String[] columna : fila) {
            CantidadTestsPorMesDTO dto = new CantidadTestsPorMesDTO();
            dto.setMes(Integer.parseInt(columna[0]));
            dto.setCantidadTests(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
