
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.ImagenProyecto;
import java.util.List;
import java.util.Optional;


public interface IImagenProyectoService {
     public List<ImagenProyecto> list();
    public Optional<ImagenProyecto> getOne(int id);
    public void save(ImagenProyecto imagen);
    public void delete(int id);
    public boolean exists(int id);
}
