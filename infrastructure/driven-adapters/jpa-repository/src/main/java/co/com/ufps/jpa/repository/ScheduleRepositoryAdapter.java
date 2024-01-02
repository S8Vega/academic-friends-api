package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.ScheduleCrudRepository;
import co.com.ufps.jpa.entities.ScheduleEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.schedule.Schedule;
import co.com.ufps.model.schedule.gateways.ScheduleRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

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
}
