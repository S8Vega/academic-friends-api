package co.com.ufps.usecase.academicfriend;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.academicfriend.gateways.AcademicFriendRepository;
import co.com.ufps.model.exceptions.UserNotFoundException;
import co.com.ufps.model.student.Student;
import co.com.ufps.model.user.User;
import co.com.ufps.usecase.TestBuilder;
import co.com.ufps.usecase.convocation.ConvocationUseCase;
import co.com.ufps.usecase.file.FileUseCase;
import co.com.ufps.usecase.security.SecurityUseCase;
import co.com.ufps.usecase.student.StudentUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AcademicFriendUseCaseTest {

    @InjectMocks
    private AcademicFriendUseCase academicFriendUseCase;
    @Mock
    private AcademicFriendRepository academicFriendRepository;
    @Mock
    private FileUseCase fileUseCase;
    @Mock
    private StudentUseCase studentUseCase;
    @Mock
    private ConvocationUseCase convocationUseCase;
    @Mock
    private SecurityUseCase securityUseCase;


    @Test
    void saveStudent() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Student student = TestBuilder.student();
        File resume = mock(File.class);
        when(studentUseCase.findByEmail(academicFriend.getEmail())).thenReturn(student);
        when(academicFriendRepository.save(academicFriend)).thenReturn(academicFriend);
        when(convocationUseCase.findCurrentConvocation()).thenReturn(TestBuilder.convocation());

        AcademicFriend response = academicFriendUseCase.save(academicFriend, resume);

        assertEquals(academicFriend, response);
        verify(studentUseCase).findByEmail(academicFriend.getEmail());
        verify(fileUseCase).save(academicFriend.getResume(), resume);
        verify(studentUseCase).remove(academicFriend.getEmail());
        verify(convocationUseCase).findCurrentConvocation();
        verify(academicFriendRepository).save(academicFriend);
    }

    @Test
    void saveAcademicFriend() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Student student = TestBuilder.student();
        student.setType(User.Constants.ACADEMIC_FRIEND);
        File resume = mock(File.class);
        when(studentUseCase.findByEmail(academicFriend.getEmail())).thenReturn(student);
        when(academicFriendRepository.save(academicFriend)).thenReturn(academicFriend);
        when(convocationUseCase.findCurrentConvocation()).thenReturn(TestBuilder.convocation());

        AcademicFriend response = academicFriendUseCase.save(academicFriend, resume);

        assertEquals(academicFriend, response);
        verify(studentUseCase).findByEmail(academicFriend.getEmail());
        verify(fileUseCase).save(academicFriend.getResume(), resume);
        verify(convocationUseCase).findCurrentConvocation();
        verify(academicFriendRepository).save(academicFriend);
    }

    @Test
    void saveException() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        File resume = mock(File.class);
        when(studentUseCase.findByEmail(academicFriend.getEmail())).thenReturn(null);

        Exception exception = assertThrows(UserNotFoundException.class, () -> {
            academicFriendUseCase.save(academicFriend, resume);
        });

        assertEquals(String.format("User %s not found", academicFriend.getEmail()), exception.getMessage());
        verify(studentUseCase).findByEmail(academicFriend.getEmail());
    }

    @Test
    void findAll() {
        List<AcademicFriend> academicFriends = new ArrayList<>();
        academicFriends.add(TestBuilder.academicFriend());
        when(academicFriendRepository.findAll()).thenReturn(academicFriends);

        List<AcademicFriend> response = academicFriendUseCase.findAll();

        assertEquals(academicFriends, response);
        verify(academicFriendRepository).findAll();
    }

    @Test
    void findByEmail() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        when(academicFriendRepository.findByEmail(academicFriend.getEmail())).thenReturn(academicFriend);

        AcademicFriend response = academicFriendUseCase.findByEmail(academicFriend.getEmail());

        assertEquals(academicFriend, response);
        verify(academicFriendRepository).findByEmail(academicFriend.getEmail());
    }

    @Test
    void update() throws IOException {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        when(academicFriendRepository.findByEmail(academicFriend.getEmail())).thenReturn(academicFriend);
        when(academicFriendRepository.save(any(AcademicFriend.class))).thenReturn(academicFriend);

        AcademicFriend response = academicFriendUseCase.update(academicFriend.getEmail(), 100, "Observations",
                AcademicFriend.Constants.PASS, "123456");

        assertEquals(academicFriend, response);
        verify(academicFriendRepository).findByEmail(academicFriend.getEmail());
    }

    @Test
    void resetPassword() throws IOException {
        String email = "sebas@test.com";
        String password = "123456";

        academicFriendUseCase.resetPassword(email, password);

        verify(securityUseCase).resetPassword(email, password);
    }

    @Test
    void addContract() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        File contract = mock(File.class);
        when(academicFriendRepository.findByEmail(academicFriend.getEmail())).thenReturn(academicFriend);

        academicFriendUseCase.addContract(academicFriend.getEmail(), contract);

        verify(academicFriendRepository).findByEmail(academicFriend.getEmail());
        verify(fileUseCase).save(academicFriend.getContract(), contract);
        verify(academicFriendRepository).save(academicFriend);
    }

    @Test
    void findByConvocation() {
        List<AcademicFriend> academicFriends = new ArrayList<>();
        academicFriends.add(TestBuilder.academicFriend());
        when(academicFriendRepository.findByConvocation(1L)).thenReturn(academicFriends);

        List<AcademicFriend> response = academicFriendUseCase.findByConvocation(1L);

        assertEquals(academicFriends, response);
        verify(academicFriendRepository).findByConvocation(1L);
    }

    @Test
    void findByCode() {
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        when(academicFriendRepository.findByCode(academicFriend.getCode())).thenReturn(academicFriend);

        AcademicFriend response = academicFriendUseCase.findByCode(academicFriend.getCode());

        assertEquals(academicFriend, response);
        verify(academicFriendRepository).findByCode(academicFriend.getCode());
    }
}