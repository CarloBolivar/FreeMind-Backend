package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.free_mind.dtos.MontoPorTipoDeTerapiaDTO;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Terapia;
import pe.edu.upc.free_mind.repositories.ITerapiaRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ITerapiaService;

import java.util.List;

/**
 * Implementación de ITerapiaService. Gestiona operaciones sobre la entidad Terapia.
 */
@Service
public class TerapiaServiceImplement implements ITerapiaService {


    /** Repositorio para acceso a la base de datos de Terapia */
    @Autowired
    
    private ITerapiaRepository tR;

    /**
     * Inserta una nueva terapia
     * @param terapia Objeto Terapia a guardar
     */
    @Override
    public void insert(Terapia terapia) {
        tR.save(terapia);
    }

    /**
     * Lista todas las terapias
     * @return Lista de Terapia
     */
    @Override
    public List<Terapia> list() {
        return tR.findAll();
    }

    /**
     * Elimina una terapia por ID
     * @param id Identificador de la terapia
     */
    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }

    /**
     * Busca una terapia por su ID
     * @param id ID buscado
     * @return Terapia encontrada o una nueva si no existe
     */
    @Override
    public Terapia listId(int id) {
        return tR.findById(id).orElse(new Terapia());
    }

    /**
     * Actualiza una terapia existente
     * @param terapia Objeto con datos modificados
     */
    @Override
    public void update(Terapia terapia) {
        tR.save(terapia);
    }

    /**
    *Lista monto por tipo de terapia
    */
    @Override
    public List<MontoPorTipoDeTerapiaDTO> listarMontosPorTipoTerapia() {
        return tR.obtenerMontoTotalPorTipoTerapia();
    }

}
