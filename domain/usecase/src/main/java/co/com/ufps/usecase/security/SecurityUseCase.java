package co.com.ufps.usecase.security;

import co.com.ufps.model.security.gateways.SecurityRepository;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class SecurityUseCase {
    private final SecurityRepository securityRepository;

    public String login(String email, String password) throws IOException {
        return securityRepository.login(email, password);
    }

    public void validate(String token) {
        securityRepository.validate(token);
    }

    public void save(String email, String password) {
        securityRepository.save(email, password);
    }
}
