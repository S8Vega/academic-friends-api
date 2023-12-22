package co.com.ufps.model.user.gateways;

import co.com.ufps.model.user.User;

public interface UserRepository {
    User save(User user);

    User findByEmail(String email);
}
