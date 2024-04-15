package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.SecurityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface SecurityCrudRepository extends CrudRepository<SecurityEntity, String>, QueryByExampleExecutor<SecurityEntity> {
    Optional<SecurityEntity> findByEmail(String email);
}
