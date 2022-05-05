
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.foto;
import com.portfolio.EduSilva.repository.fotoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FotoService implements IFotoService {
    
    
    @Autowired
    fotoRepository fotoRepository;

    @Override
    public Optional<foto> getOne(int id) {
          return fotoRepository.findById(id);
    }

    @Override
    public void save(foto foto) {
          fotoRepository.save(foto);
    }

    @Override
    public void delete(int id) {
           fotoRepository.deleteById(id);
    }

    @Override
    public boolean exists(int id) {
        return fotoRepository.existsById(id);
    }

    @Override
    public List<foto> list() {
          return fotoRepository.findByOrderById();
    }


}
