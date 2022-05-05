
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.Skill;
import java.util.List;


public interface ISkillService {
    public List<Skill> verSkill();
    public void crearSkill (Skill exp);
    public void borrarSkill (Long id);
    public Skill buscarSkill (Long id);
}
