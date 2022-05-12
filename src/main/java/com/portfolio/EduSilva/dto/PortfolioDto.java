
package com.portfolio.EduSilva.dto;

import com.portfolio.EduSilva.model.Educacion;
import com.portfolio.EduSilva.model.Experiencia;
import com.portfolio.EduSilva.model.Persona;
import com.portfolio.EduSilva.model.Proyecto;
import com.portfolio.EduSilva.model.Skill;
import com.portfolio.EduSilva.service.IEducacionService;
import com.portfolio.EduSilva.service.IExperienciaService;
import com.portfolio.EduSilva.service.IPersonaService;
import com.portfolio.EduSilva.service.IProyectoService;
import com.portfolio.EduSilva.service.ISkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EDUARDOJS
 */
@Service
public class PortfolioDto {
    
  @Autowired
    private IPersonaService persoServ;
  
   @Autowired
    private IEducacionService eduServ;
   
       @Autowired
    private IExperienciaService expServ;
       
        @Autowired
    private ISkillService  skillServ;
        
        @Autowired
        private IProyectoService proyecServ;
       
       

    public PortfolioDto() {
    }
  
 public void modificadorPersona(Persona pers) {
      Persona per = persoServ.verPersonas().get(0);
     
         if(pers.getApellido() ==null)  {
        pers.setApellido(per.getApellido());
        }
        
        if(pers.getCalle() ==null) {
        pers.setCalle(per.getCalle());
        }
        
        if(pers.getCiudad() ==null) {
        pers.setCiudad(per.getCiudad());
        }
        
        if(pers.getDocumento() == null) {
        pers.setDocumento(per.getDocumento());
        }
        
        if(pers.getEmail() ==null) {
        pers.setEmail(per.getEmail());
        }
        
        if(pers.getFechaNacimiento() ==null) {
        pers.setFechaNacimiento(per.getFechaNacimiento());
        }
        
           if(pers.getInstitucionDos() ==null) {
        pers.setInstitucionDos(per.getInstitucionDos());
        }
           
            if(pers.getInstitucionUno() ==null) {
        pers.setInstitucionUno(per.getInstitucionUno());
        }
            
              if(pers.getLinkInstitucionDos() ==null) {
        pers.setLinkInstitucionDos(per.getLinkInstitucionDos());
        }    
            
         if(pers.getLinkInstitucionUno() ==null) {
        pers.setLinkInstitucionUno(per.getLinkInstitucionUno());
        }       
        
              
         if(pers.getLocalidad() ==null) {
        pers.setLocalidad(per.getLocalidad());
        }
         
         
         if(pers.getLogoInstitucionDos() ==null) {
        pers.setLogoInstitucionDos(per.getLogoInstitucionDos());
        }
        
         
         if(pers.getLogoInstitucionUno() ==null) {
        pers.setLogoInstitucionUno(per.getLogoInstitucionUno());
        }
         
         if(pers.getNombre()  ==null) {
        pers.setNombre(per.getNombre());
        }
         
         
         if(pers.getNumero() ==null) {
        pers.setNumero(per.getNumero());
        }
         
         
         if(pers.getProvincia() ==null) {
        pers.setProvincia(per.getProvincia());
        }
         
         
         if(pers.getPuesto() ==null) {
        pers.setPuesto(per.getPuesto());
        }
         
         
         if(pers.getTelefono() == null) {
        pers.setTelefono(per.getTelefono());
        }
        
          if(pers.getZip() ==null) {
        pers.setZip(per.getZip());
        }
        
      
      }
 
 public void modificadorAcercaDe( int id, Persona acercade){
        Persona per = persoServ.verPersonas().get(id - 1);
        acercade.setId(id);
        acercade.setNombre(per.getNombre());
        acercade.setApellido(per.getApellido());
        acercade.setDocumento(per.getDocumento());
        acercade.setFechaNacimiento(per.getFechaNacimiento());
        acercade.setTelefono(per.getTelefono());
        acercade.setEmail(per.getEmail());
        acercade.setPuesto(per.getPuesto());
        acercade.setCalle(per.getCalle());
        acercade.setNumero(per.getNumero());
        acercade.setLocalidad(per.getLocalidad());
        acercade.setCiudad(per.getCiudad());
        acercade.setProvincia(per.getProvincia());
        acercade.setZip(per.getZip());
        acercade.setInstitucionDos(per.getInstitucionDos());
        acercade.setInstitucionUno(per.getInstitucionUno());
        acercade.setLinkInstitucionDos(per.getLinkInstitucionDos());
        acercade.setLinkInstitucionUno(per.getLinkInstitucionUno());
        acercade.setLogoInstitucionDos(per.getLogoInstitucionDos());
        acercade.setLogoInstitucionUno(per.getLogoInstitucionUno());
       
 
 }
 
 public void modificadorEdu(Long id,  Educacion persEdu) {
     
       List<Educacion> listEdu = eduServ.verEducacion();
        for (Educacion educacion : listEdu) {
            if (educacion.getIdEducacion().equals(id)) {
                if (persEdu.getCarrera()==null) {
                    persEdu.setCarrera(educacion.getCarrera());
                }
                if (persEdu.getEscuela()==null) {
                    persEdu.setEscuela(educacion.getEscuela());
                }
                if (persEdu.getFin()==null) {
                    persEdu.setFin(educacion.getFin());
                }
                if (persEdu.getImagen()==null) {
                    persEdu.setImagen(educacion.getImagen());
                }
                if (persEdu.getInicio()==null) {
                    persEdu.setInicio(educacion.getInicio());
                }
                if (persEdu.getNivel()==null) {
                    persEdu.setNivel(educacion.getNivel());
                }
                if (persEdu.getPuntaje()==0) {
                    persEdu.setPuntaje(educacion.getPuntaje());
                }
                if (persEdu.getTitulo()==null) {
                    persEdu.setTitulo(educacion.getTitulo());
                }
            }
        }
 }
 
  public void modificadorExp(Long id, Experiencia persExp) {
     
          List<Experiencia> exp = expServ.verExperiencia();
        for (Experiencia experiencia : exp) {
            if (experiencia.getIdExperiencia().equals(id)) {
                if (persExp.getDescripcion() ==null) {
                    persExp.setDescripcion(experiencia.getDescripcion());
                }
                if (persExp.getEmpresa() ==null) {
                    persExp.setEmpresa(experiencia.getEmpresa());
                }
                if (persExp.getFin() ==null) {
                    persExp.setFin(experiencia.getFin());
                }
                if (persExp.getImagen() ==null) {
                    persExp.setImagen(experiencia.getImagen());
                }
                if (persExp.getInicio() ==null) {
                    persExp.setInicio(experiencia.getInicio());
                }
                if (persExp.getPuesto() ==null) {
                    persExp.setPuesto(experiencia.getPuesto());
                }

            }

        }
 }
  
  public void modificadorSkill(Long id, Skill persExp) {
    List<Skill> exp = skillServ.verSkill();
        
        for (Skill skill : exp) {
            if (skill.getIdSkill().equals(id)) {
                if (persExp.getDominio()==0 ) {
                    persExp.setDominio(skill.getDominio());
                }
             
                if (persExp.getNombreSkill()== null) {
                    persExp.setNombreSkill(skill.getNombreSkill());
                }
                if (persExp.getTipoSkill()== null) {
                    persExp.setTipoSkill(skill.getTipoSkill());
                }
                if (persExp.getTipoSkill().equals("1")) {
                    persExp.setTipoSkill("soft");
                }
                if (persExp.getTipoSkill().equals("2")) {
                    persExp.setTipoSkill("hard");
                }
            }
        }
  }
  
  public void modificadorProyecto(Long id, Proyecto persProyec) {
       //Traigo la Lista de Proyectos almacenados en la base de datos,
        //mediate el metodo verProyectos().       
        List<Proyecto> proyectoList = proyecServ.verProyecto();

        //recorro la lista de proyectos almacenados en la base de datos   
        for (Proyecto proyec : proyectoList) {
            //Selecciono el proyecto de la lista que coincide con el id pasado por el cliente 
            if (proyec.getIdProyecto().equals(id)) {

                //A partir de aca, si existen campos vacios pasados por el cliente, le indico que mantega los datos,
                //del proyecto cargado con anterioridad.
                if (persProyec.getDescripcion()== null) {
                    persProyec.setDescripcion(proyec.getDescripcion());
                }

                if (persProyec.getFecha()== null) {
                    persProyec.setFecha(proyec.getFecha());
                }

                if (persProyec.getLink()== null) {
                    persProyec.setLink(proyec.getLink());
                }

                if (persProyec.getNombreProyecto()== null) {
                    persProyec.setNombreProyecto(proyec.getNombreProyecto());
                }

            }
        }
  }
  
 
  
}
