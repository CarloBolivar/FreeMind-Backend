package pe.edu.upc.free_mind.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.dtos.PagoDTO;
import pe.edu.upc.free_mind.entities.Pago;
import pe.edu.upc.free_mind.servicesinterfaces.IPagoService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador REST para la entidad Pago.
 * Expone endpoints para gestionar operaciones sobre pagos.
 */
@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private IPagoService pagoService;

    /**
     * Lista todos los pagos registrados
     * @return Lista de PagoDTO
     */
    @GetMapping
    public List<PagoDTO> listar() {
        return pagoService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PagoDTO.class);
        }).collect(Collectors.toList());
    }

    /**
     * Registra un nuevo pago
     * @param dto DTO recibido del cliente
     */
    @PostMapping
    public void insertar(@RequestBody PagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Pago p = m.map(dto, Pago.class);
        pagoService.insert(p);
    }

    /**
     * Elimina un pago por su ID
     * @param id Identificador del pago
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        pagoService.delete(id);
    }

    /**
     * Obtiene un pago por su ID
     * @param id ID buscado
     * @return Objeto DTO del pago encontrado
     */
    @GetMapping("/{id}")
    public PagoDTO obtenerPorId(@PathVariable("id") Integer id) {
        Pago p = pagoService.listId(id);
        ModelMapper m = new ModelMapper();
        return m.map(p, PagoDTO.class);
    }

    /**
     * Modifica un pago existente
     * @param dto Objeto con los datos actualizados
     */
    @PutMapping
    public void modificar(@RequestBody PagoDTO dto) {
        ModelMapper m = new ModelMapper();
        Pago p = m.map(dto, Pago.class);
        pagoService.update(p);
    }

    /**
     * Reportes
     */
    /*Carlo*/
    @GetMapping("/suma-pagos-por-mes")
    public List<String[]> obtenerSumaPagosPorMes() {
        return pagoService.obtenerSumaPagosPorMes();
    }

}
