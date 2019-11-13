package sudakova.onlineshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sudakova.onlineshop.entity.History;

import java.util.Date;
import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findAllByDateLike(Date date);

    Page<History> findAllByDateLike(Date date, Pageable pageable);

    @Query("select h from History h where h.date =: date")
    List<History> findByDate(@Param("date") Date date);
}
