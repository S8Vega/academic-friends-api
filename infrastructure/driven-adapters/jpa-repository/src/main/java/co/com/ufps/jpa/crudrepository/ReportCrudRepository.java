package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.ReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ReportCrudRepository extends CrudRepository<ReportEntity, Long>,
        QueryByExampleExecutor<ReportEntity> {
}
