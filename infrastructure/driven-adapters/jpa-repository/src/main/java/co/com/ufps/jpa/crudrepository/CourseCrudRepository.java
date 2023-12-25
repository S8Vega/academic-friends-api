package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.CourseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface CourseCrudRepository extends CrudRepository<CourseEntity, String>, QueryByExampleExecutor<CourseEntity> {
    @Query("select c from CourseEntity c where upper(c.name) like upper(concat('%', ?1, '%'))")
    List<CourseEntity> findByName(String name);
}
