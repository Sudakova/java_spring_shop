package sudakova.onlineshop.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sudakova.onlineshop.entity.Discount;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface DiscountRepository  extends JpaRepository<Discount, Long> {

    List<Discount> findAllByNameLike(String name);

    Page<Discount> findAllByNameLike(String name, Pageable pageable);

    @Query("select d from Discount d where d.name = :name")
    List<Discount> findByName(@Param("name") String name);
}
