package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Cita;
import pe.edu.upc.free_mind.repositories.ICitaRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ICitaService;

import java.util.List;

//Implementación del servicio para la entidad Cita
@Service
public class CitaServiceImplement implements ICitaService {

    //Repositorio para operaciones CRUD sobre Cita
    @Autowired
    private ICitaRepository cR;

    //Inserta una nueva cita en la base de datos
    @Override
    public void insert(Cita cita) {
        cR.save(cita);
    }

    //Lista todas las citas registradas
    @Override
    public List<Cita> list() {
        return cR.findAll();
    }

    //Elimina una cita según su ID
    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    //Obtiene una cita por su ID
    @Override
    public Cita listId(int id) {
        return cR.findById(id).orElse(new Cita());
    }

    //Actualiza una cita existente
    @Override
    public void update(Cita cita) {
        cR.save(cita);
    }

    //Reportes

    /*Carlo*/
    //Obtiene la cantidad de citas atendidas por cada psicólogo
    @Override
    public List<String[]> obtenerCantidadCitasPorPsicologo() {
        return cR.obtenerCantidadCitasPorPsicologo();
    }

    /*Deyci*/
    //Obtiene la cantidad de citas por tipo de terapia
    @Override
    public List<String[]> QuantityCitaByTerapia() {
        return cR.QuantityCitaByTerapia();
    }

    //Obtiene el total de ingresos generados por cada psicólogo
    @Override
    public List<String[]> totalIngresosPorPsicologo() {
        return cR.TotalIngresosPsicologo();
    }

    /*Erick*/
    @Override
    public List<String[]> obtenerCitasPendientes() {
        return cR.obtenerCitasPendientes();
    }
}
