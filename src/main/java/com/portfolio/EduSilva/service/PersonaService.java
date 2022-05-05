
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.Educacion;
import com.portfolio.EduSilva.model.Persona;
import com.portfolio.EduSilva.repository.IEducacionRepository;
import com.portfolio.EduSilva.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    public IPersonaRepository persoRepo;
    
     @Autowired
    public IEducacionRepository eduRepo;
    
    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
    persoRepo.save(per);
    }

    @Override
    public void borrarPersona(int id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(int id){
       return persoRepo.findById(id).orElse(null);
    }

    @Override
    public void crearPersonaEdu(Educacion perEdu) {
        eduRepo.save(perEdu);
    }

    @Override
    public void modificarPersona(Persona per) {
         persoRepo.save(per);
    }

    @Override
    public void modificarAcercaDe(Persona pers) {
        persoRepo.save(pers);
    }

}
