package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Pago;
import pe.edu.upc.free_mind.repositories.IPagoRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IPagoService;

import java.util.List;

/**
 * Implementación de IPagoService. Gestiona operaciones sobre la entidad Pago.
 */
@Service
public class PagoServiceImplement implements IPagoService {

    /** Inyección del repositorio de Pago */
    @Autowired
    private IPagoRepository pR;

    /**
     * Inserta un nuevo pago en la base de datos.
     * @param pago Objeto Pago a guardar
     */
    @Override
    public void insert(Pago pago) {
        pR.save(pago);
    }

    /**
     * Retorna todos los pagos registrados.
     * @return Lista de objetos Pago
     */
    @Override
    public List<Pago> list() {
        return pR.findAll();
    }

    /**
     * Elimina un pago por ID
     * @param id Identificador del pago
     */
    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    /**
     * Retorna un pago por ID
     * @param id Identificador buscado
     * @return Objeto Pago o uno nuevo si no existe
     */
    @Override
    public Pago listId(int id) {
        return pR.findById(id).orElse(new Pago());
    }

    /**
     * Actualiza un pago existente
     * @param pago Objeto con datos actualizados
     */
    @Override
    public void update(Pago pago) {
        pR.save(pago);
    }

    /**
     * Reportes
     */
    /* Carlo*/
    @Override
    public List<String[]> obtenerSumaPagosPorMes() {
        return pR.obtenerSumaPagosPorMes();
    }
}
