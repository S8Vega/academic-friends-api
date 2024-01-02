package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.ScheduleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ScheduleCrudRepository extends CrudRepository<ScheduleEntity, Long>,
        QueryByExampleExecutor<ScheduleEntity> {

}
