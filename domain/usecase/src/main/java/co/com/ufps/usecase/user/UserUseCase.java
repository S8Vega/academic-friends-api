package co.com.ufps.usecase.user;

import co.com.ufps.model.user.User;
import co.com.ufps.model.user.gateways.UserRepository;
import co.com.ufps.usecase.security.SecurityUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;
    private final SecurityUseCase securityUseCase;

    public User save(User user, String password) {
        User response = userRepository.save(user);
        securityUseCase.save(user.getEmail(), password);
        return response;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
