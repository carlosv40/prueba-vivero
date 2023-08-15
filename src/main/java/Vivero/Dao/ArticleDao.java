package Vivero.Dao;

import Vivero.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Articulo, Long> {

}
