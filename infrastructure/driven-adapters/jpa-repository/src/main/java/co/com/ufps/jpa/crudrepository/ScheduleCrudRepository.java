package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.ScheduleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface ScheduleCrudRepository extends CrudRepository<ScheduleEntity, Long>,
        QueryByExampleExecutor<ScheduleEntity> {

    @Query("SELECT s FROM ScheduleEntity s JOIN s.academicFriends a WHERE a.email = ?1")
    List<ScheduleEntity> findByAcademicFriendEmail(String academicFriendEmail);

    @Query("SELECT s FROM ScheduleEntity s WHERE s.day = ?1 AND s.hour = ?2")
    ScheduleEntity findByDayAndHour(DayOfWeek day, LocalTime hour);

}
