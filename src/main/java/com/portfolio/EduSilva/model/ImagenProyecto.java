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

@Getter
@Setter
@Entity
public class ImagenProyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String imagenUrl;
    private String imagenId;

    @ManyToOne
    @JoinColumn(name = "FK_Proyecto", nullable = false, updatable = false)
    @JsonBackReference
    private Proyecto proyecto;

    public ImagenProyecto() {
    }

    public ImagenProyecto(int id, String name, String imagenUrl, String imagenId, Proyecto proyecto) {
        this.id = id;
        this.name = name;
        this.imagenUrl = imagenUrl;
        this.imagenId = imagenId;
        this.proyecto = proyecto;
    }

    public ImagenProyecto(String name, String imagenUrl, String imagenId) {
        this.name = name;
        this.imagenUrl = imagenUrl;
        this.imagenId = imagenId;
    
    }

}
