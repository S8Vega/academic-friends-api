package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CourseCrudRepository extends CrudRepository<CourseEntity, String>, QueryByExampleExecutor<CourseEntity> {
}
