package sudakova.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sudakova.onlineshop.entity.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByEmailLike(String email);

    @Query("select u from User u where u.email = :email")
    Optional<User> getByEmail(@Param("email") String email);
}
