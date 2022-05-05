
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.ImagenProyecto;
import com.portfolio.EduSilva.repository.ImagenProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImagenProyectoService implements IImagenProyectoService {
    
    @Autowired
    ImagenProyectoRepository imagenProyectoRepository;

    @Override
    public Optional<ImagenProyecto> getOne(int id) {
          return imagenProyectoRepository.findById(id);
    }

    @Override
    public void save(ImagenProyecto foto) {
          imagenProyectoRepository.save(foto);
    }

    @Override
    public void delete(int id) {
           imagenProyectoRepository.deleteById(id);
    }

    @Override
    public boolean exists(int id) {
        return imagenProyectoRepository.existsById(id);
    }

    @Override
    public List<ImagenProyecto> list() {
          return imagenProyectoRepository.findByOrderById();
    }

}
