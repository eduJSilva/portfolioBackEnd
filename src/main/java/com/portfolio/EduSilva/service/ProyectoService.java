
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.Proyecto;
import com.portfolio.EduSilva.repository.IProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public IProyectoRepository proyecRepo;
    
    @Override
    public List<Proyecto> verProyecto() {
        return proyecRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyecto exp) {
    proyecRepo.save(exp);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyecRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id){
       return proyecRepo.findById(id).orElse(null);
    }

}
