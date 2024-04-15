package co.com.ufps.model.security.gateways;

import java.io.IOException;
import java.security.SignatureException;

public interface SecurityRepository {
    String login(String email, String password, String role) throws IOException;

    void validate(String token);

    void save(String email, String password, String role);

    String getTokenRole(String token);

    void resetPassword(String email, String password) throws IOException, SignatureException;

    void resetPassword(String email, String newPassword, String code) throws IOException, SignatureException;

    void forgotPassword(String email) throws IOException, SignatureException;

    void delete(String email) throws IOException;
}
