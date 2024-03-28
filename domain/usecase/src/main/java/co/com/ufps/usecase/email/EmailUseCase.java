package co.com.ufps.usecase.email;

import co.com.ufps.model.email.Email;
import co.com.ufps.model.email.gateways.EmailRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailUseCase {
    private final EmailRepository emailRepository;

    public void sendEmail(Email email) {
        emailRepository.send(email);
    }
}
