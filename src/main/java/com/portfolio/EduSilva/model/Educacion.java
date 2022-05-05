package com.portfolio.EduSilva.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion implements Serializable {

   @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idEducacion;
    private String escuela;
    private String titulo;
    private String nivel;
    private String imagen;
    private String carrera;
    private String estado;
    private int puntaje;
    private String inicio;
    private String fin;
    
     @ManyToOne
    @JoinColumn(name = "FK_PERSONA", nullable = false, updatable = false)
    @JsonBackReference
    private Persona persona;

    public Educacion() {
    }

    public Educacion(Long idEducacion, String escuela, String titulo, String nivel, String imagen, String carrera, String estado, int puntaje, String anioInicio, String anioFin, Persona persona) {
        this.idEducacion = idEducacion;
        this.escuela = escuela;
        this.titulo = titulo;
        this.nivel = nivel;
        this.imagen = imagen;
        this.carrera = carrera;
        this.estado = estado;
        this.puntaje = puntaje;
        this.inicio = anioInicio;
        this.fin = anioFin;
        this.persona = persona;
    }
     
}
