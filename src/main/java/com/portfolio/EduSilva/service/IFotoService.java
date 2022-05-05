
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.foto;
import java.util.List;
import java.util.Optional;


public interface IFotoService {
     public List<foto> list();
    public Optional<foto> getOne(int id);
    public void save(foto imagen);
    public void delete(int id);
    public boolean exists(int id);
}
