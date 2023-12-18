package co.com.ufps.jpa;

import co.com.ufps.jpa.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserCrudRepository extends CrudRepository<UserEntity, String>, QueryByExampleExecutor<UserEntity> {
}
