package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.FileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface FileCrudRepository extends CrudRepository<FileEntity, String>, QueryByExampleExecutor<FileEntity> {
    FileEntity findByName(String name);
}
