
package com.portfolio.EduSilva.repository;

import com.portfolio.EduSilva.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository <Proyecto, Long> {
    
}
