package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.ConsultancyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface ConsultancyCrudRepository extends CrudRepository<ConsultancyEntity, Long>,
        QueryByExampleExecutor<ConsultancyEntity> {

    @Query("SELECT c FROM ConsultancyEntity c WHERE c.student.email = ?1")
    List<ConsultancyEntity> findByStudent(String email);
}
