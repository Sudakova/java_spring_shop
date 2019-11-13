package sudakova.onlineshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sudakova.onlineshop.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByNameLike(String name);

    Page<Category> findAllByNameLike(String name, Pageable pageable);

    @Query("select c from Category c where c.name =: name")
    List<Category> findByName(@Param("name") String name);
}
