
package com.portfolio.EduSilva.repository;

import com.portfolio.EduSilva.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository <Educacion, Long> {
    
}
