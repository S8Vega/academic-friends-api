package co.com.ufps.model.security.gateways;

import java.io.IOException;

public interface SecurityRepository {
    String login(String email, String password, String role) throws IOException;

    void validate(String token);

    void save(String email, String password, String role);

    String getTokenRole(String token);
}
