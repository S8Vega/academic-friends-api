package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.ConvocationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ConvocationCrudRepository extends CrudRepository<ConvocationEntity, Long>,
        QueryByExampleExecutor<ConvocationEntity> {
}
