package sudakova.onlineshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sudakova.onlineshop.entity.Storage;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long>, JpaSpecificationExecutor<Storage> {
}
