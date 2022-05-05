
package com.portfolio.EduSilva.repository;

import com.portfolio.EduSilva.model.Imagen;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
   List<Imagen> findByOrderById();
}
