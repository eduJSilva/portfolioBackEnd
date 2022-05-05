
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    public List<Proyecto> verProyecto();
    public void crearProyecto (Proyecto exp);
    public void borrarProyecto (Long id);
    public Proyecto buscarProyecto (Long id);
}
