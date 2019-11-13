package sudakova.onlineshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sudakova.onlineshop.entity.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByEmailLike(String email);

    Page<User> findAllByEmailLike(String email, Pageable pageable);

    @Query("select u from User u where u.email =: email")
    List<User> findByEmail(@Param("email") String email);
}
