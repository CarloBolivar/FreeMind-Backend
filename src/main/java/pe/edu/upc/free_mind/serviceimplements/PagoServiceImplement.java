package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Pago;
import pe.edu.upc.free_mind.repositories.IPagoRepository;
import pe.edu.upc.free_mind.servicesinterfaces.IPagoService;

import java.util.List;

//Implementación del servicio para la entidad Pago
@Service
public class PagoServiceImplement implements IPagoService {

    //Repositorio para operaciones CRUD sobre Pago
    @Autowired
    private IPagoRepository pR;

    //Inserta un nuevo pago en la base de datos
    @Override
    public void insert(Pago pago) {
        pR.save(pago);
    }

    //Lista todos los pagos registrados
    @Override
    public List<Pago> list() {
        return pR.findAll();
    }

    //Elimina un pago según su ID
    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    //Obtiene un pago por su ID
    @Override
    public Pago listId(int id) {
        return pR.findById(id).orElse(new Pago());
    }

    //Actualiza un pago existente
    @Override
    public void update(Pago pago) {
        pR.save(pago);
    }

    //Reportes

    /*Carlo*/
    //Obtiene la suma de pagos agrupados por mes
    @Override
    public List<String[]> obtenerSumaPagosPorMes() {
        return pR.obtenerSumaPagosPorMes();
    }

    /*Erick*/
    //Obtiene el monto total generado por el tipo de terapia elegido
    @Override
    public List<String[]> obtenerMontoPorTipoDeTerapia() {
        return pR.obtenerMontoPorTipoDeTerapia();
    }
}
