package co.com.ufps.usecase.security;

import co.com.ufps.model.security.gateways.SecurityRepository;
import co.com.ufps.model.user.User;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.security.SignatureException;

@RequiredArgsConstructor
public class SecurityUseCase {
    private final SecurityRepository securityRepository;

    public String login(String email, String password, String role) throws IOException {
        return securityRepository.login(email, password, role);
    }

    public void validate(String token) {
        securityRepository.validate(token);
    }

    public void validate(String token, String... roles) throws SignatureException {
        String tokenRole = getTokenRole(token);
        if (tokenRole.equals(User.Constants.DIRECTOR)) return;
        for (String role : roles) {
            if (tokenRole.equals(role)) {
                return;
            }
        }
        throw new SignatureException("El rol del token no es valido");
    }

    public void save(String email, String password, String role) throws IOException {
        securityRepository.save(email, password, role);
        login(email, password, role);
    }

    public String getTokenRole(String token) {
        return securityRepository.getTokenRole(token);
    }

    public void resetPassword(String email, String password) throws IOException {
        securityRepository.resetPassword(email, password);
    }
}
