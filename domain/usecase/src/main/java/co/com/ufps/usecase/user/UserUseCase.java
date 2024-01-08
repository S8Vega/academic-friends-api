package co.com.ufps.usecase.user;

import co.com.ufps.model.user.User;
import co.com.ufps.model.user.gateways.UserRepository;
import co.com.ufps.usecase.security.SecurityUseCase;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;
    private final SecurityUseCase securityUseCase;

    public User save(User user, String password) throws IOException {
        if (!user.getEmail().endsWith(User.Constants.EMAIL)) {
            throw new IllegalArgumentException(String.format("El correo %s no es valido", user.getEmail()));
        }
        User response = userRepository.save(user);
        securityUseCase.save(user.getEmail(), password, user.getType());
        return response;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
