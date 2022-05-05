package com.portfolio.EduSilva.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Entity
@DynamicUpdate
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Long documento;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String telefono;
    private String email;
    private String puesto;
    private String calle;
    private String numero;
    private String localidad;
    private String ciudad;
    private String provincia;
    private String zip;
     private String logoInstitucionUno, institucionUno, linkInstitucionUno;
     private String logoInstitucionDos, institucionDos, linkInstitucionDos;
  
    @Column(name="acerca_de" ,columnDefinition = "TEXT")
    private String acercaDe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    @JsonManagedReference
    private List<Experiencia> listaDeExperiencias;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    @JsonManagedReference
    private List<Educacion> listaDeEducacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    @JsonManagedReference
    private List<Skill> listaDeSkills;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    @JsonManagedReference
    private List<Proyecto> listaDeProyectos;

    public Persona() {
    }

    public Persona(int id, Long documento, String nombre, String apellido, String fechaNacimiento, String telefono, String email, String puesto, String calle, String numero, String localidad, String ciudad, String provincia, String zip, String logoInstitucionUno, String institucionUno, String linkInstitucionUno, String logoInstitucionDos, String institucionDos, String linkInstitucionDos, String acercaDe, List<Experiencia> listaDeExperiencias, List<Educacion> listaDeEducacion, List<Skill> listaDeSkills, List<Proyecto> listaDeProyectos) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.puesto = puesto;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.zip = zip;
        this.logoInstitucionUno = logoInstitucionUno;
        this.institucionUno = institucionUno;
        this.linkInstitucionUno = linkInstitucionUno;
        this.logoInstitucionDos = logoInstitucionDos;
        this.institucionDos = institucionDos;
        this.linkInstitucionDos = linkInstitucionDos;
        this.acercaDe = acercaDe;
        this.listaDeExperiencias = listaDeExperiencias;
        this.listaDeEducacion = listaDeEducacion;
        this.listaDeSkills = listaDeSkills;
        this.listaDeProyectos = listaDeProyectos;
    }

    
}
