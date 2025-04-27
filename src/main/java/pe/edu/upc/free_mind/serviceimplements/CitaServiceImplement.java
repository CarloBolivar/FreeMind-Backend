package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Cita;
import pe.edu.upc.free_mind.repositories.ICitaRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ICitaService;


import java.util.List;

/**
 * Implementación de ICitaService. Gestiona operaciones lógicas sobre la entidad Cita.
 */
@Service
public class CitaServiceImplement implements ICitaService {

    /** Inyección del repositorio de Cita */
    @Autowired
    private ICitaRepository cR;

    /**
     * Inserta una nueva cita en la base de datos.
     * @param cita Objeto Cita a insertar
     */
    @Override
    public void insert(Cita cita) {
        cR.save(cita);
    }

    /**
     * Retorna todas las citas registradas.
     * @return Lista de objetos Cita
     */
    @Override
    public List<Cita> list() {
        return cR.findAll();
    }

    /**
     * Elimina una cita por ID
     * @param id Identificador de la cita
     */
    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    /**
     * Retorna una cita específica por ID
     * @param id Identificador buscado
     * @return Objeto Cita o uno nuevo si no existe
     */
    @Override
    public Cita listId(int id) {
        return cR.findById(id).orElse(new Cita());
    }

    /**
     * Actualiza una cita existente
     * @param cita Objeto con datos actualizados
     */
    @Override
    public void update(Cita cita) {
        cR.save(cita);
    }

    /**
     * Obtiene la cantidad de citas atendidas por cada psicólogo.
     * @return Lista de objetos CantidadCitasPorPsicologoDTO con los datos
     */
    @Override
    public List<String[]> obtenerCantidadCitasPorPsicologo() {
        return cR.obtenerCantidadCitasPorPsicologo();
    }

    /*D*/
    @Override
    public List<String[]> QuantityCitaByTerapia() {
        return cR.QuantityCitaByTerapia();
    }

    @Override
    public List<String[]> totalIngresosPorPsicologo() {
        return cR.TotalIngresosPsicologo();
    }


}
