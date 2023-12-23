package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.ConvocationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ConvocationCrudRepository extends CrudRepository<ConvocationEntity, Long>,
        QueryByExampleExecutor<ConvocationEntity> {
    @Query(value = "SELECT * " +
            "FROM convocation c " +
            "WHERE CAST(:currentDate AS timestamp) >= c.opening_date AND " +
            "CAST(:currentDate AS timestamp) <= c.results_release_date",
            nativeQuery = true)
    ConvocationEntity findCurrentConvocation(@Param("currentDate") String currentDate);
}
