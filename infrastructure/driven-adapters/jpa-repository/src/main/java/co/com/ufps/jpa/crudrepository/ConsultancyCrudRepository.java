package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.ConsultancyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ConsultancyCrudRepository extends CrudRepository<ConsultancyEntity, Long>,
        QueryByExampleExecutor<ConsultancyEntity> {

}
