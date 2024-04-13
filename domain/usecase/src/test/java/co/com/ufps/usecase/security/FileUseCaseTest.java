package co.com.ufps.usecase.security;

import co.com.ufps.model.security.gateways.SecurityRepository;
import co.com.ufps.model.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.security.SignatureException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FileUseCaseTest {
    @InjectMocks
    private SecurityUseCase securityUseCase;
    @Mock
    private SecurityRepository securityRepository;

    @Test
    void login() throws IOException {
        String token = "token super secreto";
        String email = "email";
        String password = "password";
        String role = "role";
        when(securityRepository.login(email, password, role)).thenReturn(token);

        String result = securityUseCase.login(email, password, role);

        assertEquals(token, result);
        verify(securityRepository).login(email, password, role);
    }

    @Test
    void validate() {
        String token = "token super secreto";

        securityUseCase.validate(token);

        verify(securityRepository).validate(token);
    }

    @Test
    void testValidate() throws SignatureException {
        String token = "token super secreto";
        String role = User.Constants.ACADEMIC_FRIEND;
        String[] roles = {User.Constants.DIRECTOR, User.Constants.ACADEMIC_FRIEND};
        when(securityRepository.getTokenRole(token)).thenReturn(role);

        securityUseCase.validate(token, roles);

        verify(securityRepository).getTokenRole(token);
    }

    @Test
    void save() throws IOException {
        String email = "email";
        String password = "password";
        String role = "role";

        securityUseCase.save(email, password, role);

        verify(securityRepository).save(email, password, role);
        verify(securityRepository).login(email, password, role);
    }

    @Test
    void getTokenRole() {
        String token = "token super secreto";

        securityUseCase.getTokenRole(token);

        verify(securityRepository).getTokenRole(token);
    }

    @Test
    void resetPassword() throws IOException {
        String email = "email";
        String password = "password";

        securityUseCase.resetPassword(email, password);

        verify(securityRepository).resetPassword(email, password);
    }

    @Test
    void delete() throws IOException {
        String email = "email";

        securityUseCase.delete(email);

        verify(securityRepository).delete(email);
    }
}