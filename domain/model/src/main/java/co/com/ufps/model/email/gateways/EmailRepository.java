package co.com.ufps.model.email.gateways;

import co.com.ufps.model.email.Email;

public interface EmailRepository {
    void send(Email email);
}
