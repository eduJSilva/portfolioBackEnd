
package com.portfolio.EduSilva.repository;

import com.portfolio.EduSilva.model.ImagenProyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenProyectoRepository extends JpaRepository<ImagenProyecto, Integer> {
      List<ImagenProyecto> findByOrderById();
}
