
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
public class Skill implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSkill;
    private String nombreSkill;
    private String tipoSkill;
    private int dominio = 0;
    
    @ManyToOne
    @JoinColumn(name = "FK_Persona", nullable = false, updatable = false)
    @JsonBackReference
    private Persona persona;

    public Skill() {
    }

    public Skill(Long idSkill, String nombreSkill, String tipoSkill, int dominio, Persona persona) {
        this.idSkill = idSkill;
        this.nombreSkill = nombreSkill;
        this.tipoSkill = tipoSkill;
        this.dominio = dominio;
        this.persona = persona;
    }

}
