package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.ScheduleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface ScheduleCrudRepository extends CrudRepository<ScheduleEntity, Long>,
        QueryByExampleExecutor<ScheduleEntity> {

    @Query("SELECT s FROM ScheduleEntity s WHERE s.academicFriend.email = ?1")
    List<ScheduleEntity> findByAcademicFriendEmail(String academicFriendEmail);

}
