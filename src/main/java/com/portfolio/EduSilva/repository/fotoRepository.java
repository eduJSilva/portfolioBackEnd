
package com.portfolio.EduSilva.repository;

import com.portfolio.EduSilva.model.foto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fotoRepository extends JpaRepository<foto, Integer> {
      List<foto> findByOrderById();
}
