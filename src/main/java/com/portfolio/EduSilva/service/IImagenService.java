
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.Imagen;
import java.util.List;
import java.util.Optional;

public interface IImagenService {
    public List<Imagen> list();
    public Optional<Imagen> getOne(int id);
    public void save(Imagen imagen);
    public void delete(int id);
    public boolean exists(int id);
}
