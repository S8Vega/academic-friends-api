package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.AcademicFriendCrudRepository;
import co.com.ufps.jpa.entities.AcademicFriendEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.academicfriend.gateways.AcademicFriendRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AcademicFriendRepositoryAdapter extends AdapterOperations<AcademicFriend, AcademicFriendEntity, String,
        AcademicFriendCrudRepository>
        implements AcademicFriendRepository {

    public AcademicFriendRepositoryAdapter(AcademicFriendCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, AcademicFriend.class));
    }

    @Override
    public AcademicFriend save(AcademicFriend academicFriend) {
        AcademicFriendEntity academicFriendEntity = mapper.map(academicFriend, AcademicFriendEntity.class);
        return mapper.map(repository.save(academicFriendEntity), AcademicFriend.class);
    }

    @Override
    public List<AcademicFriend> findAll() {
        Iterable<AcademicFriendEntity> academicFriendEntities = repository.findAll();
        List<AcademicFriend> academicFriends = new ArrayList<>();
        for (AcademicFriendEntity academicFriendEntity : academicFriendEntities) {
            academicFriends.add(mapper.map(academicFriendEntity, AcademicFriend.class));
        }
        return academicFriends;
    }
}
