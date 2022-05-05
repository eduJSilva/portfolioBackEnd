
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.Imagen;
import com.portfolio.EduSilva.repository.ImagenRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImagenService implements IImagenService {
    
    @Autowired
    ImagenRepository imagenRepository;

    @Override
    public List<Imagen> list() {
        return imagenRepository.findByOrderById();
    }

    @Override
    public Optional<Imagen> getOne(int id) {
        return imagenRepository.findById(id);
    }

    @Override
    public void save(Imagen imagen) {
       imagenRepository.save(imagen);
    }

    @Override
    public void delete(int id) {
        imagenRepository.deleteById(id);
    }
     
    @Override
    public boolean exists(int id) {
    return imagenRepository.existsById(id);
    }
    
   
    
}
