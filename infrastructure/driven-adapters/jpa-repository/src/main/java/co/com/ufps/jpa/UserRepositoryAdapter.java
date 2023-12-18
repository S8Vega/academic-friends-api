package co.com.ufps.jpa;

import co.com.ufps.jpa.entities.UserEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.user.User;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAdapter extends AdapterOperations<User, UserEntity, String, UserCrudRepository>
// implements ModelRepository from domain
{

    public UserRepositoryAdapter(UserCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, User.class));
    }
}
