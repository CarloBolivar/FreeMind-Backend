package pe.edu.upc.free_mind.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.free_mind.dtos.MontoPorTipoDeTerapiaDTO;
import org.springframework.stereotype.Service;
import pe.edu.upc.free_mind.entities.Terapia;
import pe.edu.upc.free_mind.repositories.ITerapiaRepository;
import pe.edu.upc.free_mind.servicesinterfaces.ITerapiaService;

import java.util.List;

//Implementación del servicio para la entidad Terapia
@Service
public class TerapiaServiceImplement implements ITerapiaService {

    //Repositorio para operaciones CRUD sobre Terapia
    @Autowired
    private ITerapiaRepository tR;

    //Inserta una nueva terapia en la base de datos
    @Override
    public void insert(Terapia terapia) {
        tR.save(terapia);
    }

    //Lista todas las terapias registradas
    @Override
    public List<Terapia> list() {
        return tR.findAll();
    }

    //Elimina una terapia según su ID
    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }

    //Obtiene una terapia por su ID
    @Override
    public Terapia listId(int id) {
        return tR.findById(id).orElse(new Terapia());
    }

    //Actualiza los datos de una terapia existente
    @Override
    public void update(Terapia terapia) {
        tR.save(terapia);
    }
}
