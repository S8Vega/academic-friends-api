package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.ScheduleCrudRepository;
import co.com.ufps.jpa.entities.ScheduleEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.schedule.Schedule;
import co.com.ufps.model.schedule.gateways.ScheduleRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleRepositoryAdapter extends AdapterOperations<Schedule, ScheduleEntity, Long,
        ScheduleCrudRepository>
        implements ScheduleRepository {

    public ScheduleRepositoryAdapter(ScheduleCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Schedule.class));
    }

    @Override
    public Schedule save(Schedule schedule) {
        ScheduleEntity entity = this.mapper.map(schedule, ScheduleEntity.class);
        return mapper.map(repository.save(entity), Schedule.class);
    }

    @Override
    public List<Schedule> findAll() {
        Iterable<ScheduleEntity> entities = repository.findAll();
        List<Schedule> schedules = new ArrayList<>();
        for (ScheduleEntity entity : entities) {
            schedules.add(this.mapper.map(entity, Schedule.class));
        }
        return schedules;
    }

    @Override
    public List<Schedule> findByAcademicFriend(String academicFriendEmail) {
        List<ScheduleEntity> entities = repository.findByAcademicFriendEmail(academicFriendEmail);
        List<Schedule> schedules = new ArrayList<>();
        for (ScheduleEntity entity : entities) {
            schedules.add(this.mapper.map(entity, Schedule.class));
        }
        return schedules;
    }

    @Override
    public Schedule findByDayAndHour(DayOfWeek day, LocalTime hour) {
        ScheduleEntity entity = repository.findByDayAndHour(day, hour);
        return (entity == null ? null : this.mapper.map(entity, Schedule.class));
    }
}
