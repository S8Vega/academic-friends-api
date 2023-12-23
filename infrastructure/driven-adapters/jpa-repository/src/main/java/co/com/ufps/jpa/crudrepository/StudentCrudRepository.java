package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface StudentCrudRepository extends CrudRepository<StudentEntity, String>, QueryByExampleExecutor<StudentEntity> {
    StudentEntity findByEmail(String email);
}
