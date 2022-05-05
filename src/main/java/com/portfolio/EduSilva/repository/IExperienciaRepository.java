
package com.portfolio.EduSilva.repository;

import com.portfolio.EduSilva.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository <Experiencia, Long> {
    
}
