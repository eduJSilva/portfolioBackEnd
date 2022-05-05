
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    public List<Experiencia> verExperiencia();
    public void crearExperiencia (Experiencia exp);
    public void borrarExperiencia (Long id);
    public Experiencia buscarExperiencia (Long id);
}
