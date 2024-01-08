package co.com.ufps.usecase.user;

import co.com.ufps.model.user.User;
import co.com.ufps.model.user.gateways.UserRepository;
import co.com.ufps.usecase.TestBuilder;
import co.com.ufps.usecase.security.SecurityUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {
    @InjectMocks
    private UserUseCase userUseCase;
    @Mock
    private UserRepository userRepository;
    @Mock
    private SecurityUseCase securityUseCase;

    @Test
    void save() throws IOException {
        User user = TestBuilder.user();
        String password = "123456";
        when(userRepository.save(user)).thenReturn(user);

        User response = userUseCase.save(user, password);

        assertEquals(user, response);
        verify(userRepository).save(user);
        verify(securityUseCase).save(user.getEmail(), password, user.getType());
    }

    @Test
    void findByEmail() {
        User user = TestBuilder.user();
        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        User response = userUseCase.findByEmail(user.getEmail());

        assertEquals(user, response);
        verify(userRepository).findByEmail(user.getEmail());
    }
}