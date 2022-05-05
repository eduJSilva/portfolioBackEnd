
package com.portfolio.EduSilva.service;

import com.portfolio.EduSilva.model.Skill;
import com.portfolio.EduSilva.repository.ISkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{

    @Autowired
    public ISkillRepository expRepo;
    
    @Override
    public List<Skill> verSkill() {
        return expRepo.findAll();
    }

    @Override
    public void crearSkill(Skill exp) {
    expRepo.save(exp);
    }

    @Override
    public void borrarSkill(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Long id){
       return expRepo.findById(id).orElse(null);
    }

}
