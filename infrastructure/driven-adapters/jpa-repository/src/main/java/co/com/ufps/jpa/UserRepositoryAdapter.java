package co.com.ufps.jpa;

import co.com.ufps.jpa.entities.UserEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.user.User;
import co.com.ufps.model.user.gateways.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAdapter extends AdapterOperations<User, UserEntity, String, UserCrudRepository>
        implements UserRepository {

    public UserRepositoryAdapter(UserCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, User.class));
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        return mapper.map(repository.save(userEntity), User.class);
    }

    @Override
    public User findByEmail(String email) {
        UserEntity userEntity = repository.findByEmail(email);
        return mapper.map(userEntity, User.class);
    }
}
