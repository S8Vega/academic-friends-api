package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.ReportEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface ReportCrudRepository extends CrudRepository<ReportEntity, Long>,
        QueryByExampleExecutor<ReportEntity> {

    @Query("SELECT r FROM ReportEntity r WHERE r.academicFriend.email = ?1")
    List<ReportEntity> findByAcademicFriend(String email);
}
