package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.CantidadMontoPorTipoDeTerapiaDTO;
import pe.edu.upc.free_mind.dtos.PagoDTO;
import pe.edu.upc.free_mind.dtos.CantidadSumaPagosPorMesDTO;
import pe.edu.upc.free_mind.entities.Pago;
import pe.edu.upc.free_mind.servicesinterfaces.IPagoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Controlador REST para gestionar operaciones sobre pagos
@RestController
@RequestMapping("/pagos")
public class PagoController {

    //Servicio para operaciones sobre Pago
    @Autowired
    private IPagoService pagoService;

    //Lista todos los pagos registrados
    @GetMapping
    public List<PagoDTO> listar() {
        return pagoService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PagoDTO.class);
        }).collect(Collectors.toList());
    }

    //Registra un nuevo pago
    @PostMapping
    public void insertar(@RequestBody PagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Pago p = m.map(dto, Pago.class);
        pagoService.insert(p);
    }

    //Elimina un pago por su ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        pagoService.delete(id);
    }

    //Obtiene un pago por su ID
    @GetMapping("/{id}")
    public PagoDTO obtenerPorId(@PathVariable("id") Integer id) {
        Pago p = pagoService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(p, PagoDTO.class);
    }

    //Modifica un pago existente
    @PutMapping
    public void modificar(@RequestBody PagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Pago p = m.map(dto, Pago.class);
        pagoService.update(p);
    }

    //Reportes

    /*Carlo*/

    //Obtiene la suma de pagos agrupados por mes
    @GetMapping("/suma-pagos-por-mes")
    public List<CantidadSumaPagosPorMesDTO> obtenerSumaPagosPorMes() {
        List<CantidadSumaPagosPorMesDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = pagoService.obtenerSumaPagosPorMes();
        for (String[] columna : fila) {
            CantidadSumaPagosPorMesDTO dto = new CantidadSumaPagosPorMesDTO();
            dto.setMes(Integer.parseInt(columna[0]));
            dto.setMontoTotal(Double.parseDouble(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    /*Erick*/
    //Obtiene el monto total generado por tipo de terapia
    @GetMapping("/monto-total-por-tipo-de-terapia")
    public List<CantidadMontoPorTipoDeTerapiaDTO> obtenerMontoPorTipoDeTerapia() {
        List<CantidadMontoPorTipoDeTerapiaDTO> dtoLista = new ArrayList<>();
        List<String[]> fila = pagoService.obtenerMontoPorTipoDeTerapia();
        for (String[] columna : fila) {
            CantidadMontoPorTipoDeTerapiaDTO dto = new CantidadMontoPorTipoDeTerapiaDTO();
            dto.setTipoTerapia(columna[0]);
            dto.setMontoTotal(Double.parseDouble(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
