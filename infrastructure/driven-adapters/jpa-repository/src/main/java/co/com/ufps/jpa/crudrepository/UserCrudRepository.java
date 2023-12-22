package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserCrudRepository extends CrudRepository<UserEntity, String>, QueryByExampleExecutor<UserEntity> {
    UserEntity findByEmail(String email);
}
