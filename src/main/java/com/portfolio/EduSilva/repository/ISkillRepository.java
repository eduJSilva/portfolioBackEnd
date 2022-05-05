
package com.portfolio.EduSilva.repository;

import com.portfolio.EduSilva.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository <Skill, Long> {
    
}
