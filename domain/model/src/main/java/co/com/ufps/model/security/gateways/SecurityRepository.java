package co.com.ufps.model.security.gateways;

import java.io.IOException;

public interface SecurityRepository {
    String login(String email, String password) throws IOException;

    void validate(String token);

    void save(String email, String password);
}
