package sudakova.onlineshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sudakova.onlineshop.entity.Product;

import java.util.List;


@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByNameLike(String name);

    Page<Product> findAllByNameLike(String name, Pageable pageable);

    @Query("select p from Product p where p.name =: name")
    List<Product> findByName(@Param("name") String name);

}

