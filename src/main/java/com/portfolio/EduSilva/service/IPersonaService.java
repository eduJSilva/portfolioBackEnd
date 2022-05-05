
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.Educacion;
import com.portfolio.EduSilva.model.Persona;
import java.util.List;


public interface IPersonaService {
    public List<Persona> verPersonas();
    public void crearPersona (Persona per);
    public void modificarPersona(Persona per);
    public void borrarPersona (int id);
    public Persona buscarPersona (int id);
    public void crearPersonaEdu (Educacion perEdu);
    public void modificarAcercaDe(Persona pers);
}
