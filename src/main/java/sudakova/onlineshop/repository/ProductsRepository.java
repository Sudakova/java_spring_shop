package sudakova.onlineshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sudakova.onlineshop.entity.Products;

import java.util.List;


@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    List<Products> findAllByNameLike(String name);

    Page<Products> findAllByNameLike(String name, Pageable pageable);

    @Query("select p from Products p where p.name =: name")
    List<Products> findByName(@Param("name") String name);

}

