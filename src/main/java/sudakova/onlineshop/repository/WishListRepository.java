package sudakova.onlineshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sudakova.onlineshop.entity.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long>, JpaSpecificationExecutor<WishList> {
}
