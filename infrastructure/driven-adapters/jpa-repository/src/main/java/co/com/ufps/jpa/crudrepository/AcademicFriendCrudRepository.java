package co.com.ufps.jpa.crudrepository;

import co.com.ufps.jpa.entities.AcademicFriendEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface AcademicFriendCrudRepository extends CrudRepository<AcademicFriendEntity, String>,
        QueryByExampleExecutor<AcademicFriendEntity> {
    @Query("SELECT af FROM AcademicFriendEntity af JOIN ConvocationEntity c ON af.convocation.id = c.id WHERE c.id = ?1")
    List<AcademicFriendEntity> findByConvocation(Long id);

    @Query("SELECT af FROM AcademicFriendEntity af WHERE af.code = ?1")
    Optional<AcademicFriendEntity> findByCode(String code);
}
