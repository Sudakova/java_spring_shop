package sudakova.onlineshop.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sudakova.onlineshop.entity.Gender;


import java.util.List;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {

    List<Gender> findAllByNameLike(String name);

    Page<Gender> findAllByNameLike(String name, Pageable pageable);

    @Query("select g from Gender g where g.name =: name")
    List<Gender> findByName(@Param("name") String name);
}
