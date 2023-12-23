package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.AcademicFriendEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface AcademicFriendCrudRepository extends CrudRepository<AcademicFriendEntity, String>,
        QueryByExampleExecutor<AcademicFriendEntity> {
}
