package co.com.ufps.usecase.student;

import co.com.ufps.model.student.Student;
import co.com.ufps.model.student.gateways.StudentRepository;
import co.com.ufps.usecase.TestBuilder;
import co.com.ufps.usecase.file.FileUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentUseCaseTest {
    @InjectMocks
    private StudentUseCase studentUseCase;
    @Mock
    private FileUseCase fileUseCase;
    @Mock
    private StudentRepository studentRepository;

    @Test
    void save() {
        // [{code=1151636.0, name=Brayan Sebastian Vega Garcia, semester=13.0, email=brayansebastianvega@ufps.edu.co}]
        Object students = new Object();
        when(fileUseCase.read(students)).thenReturn(List.of(Map.of("code", 1151636.0,
                "name", "Brayan Sebastian Vega Garcia",
                "semester", 13.0,
                "email", "sebas@ufps.edu.co")));
        when(studentRepository.findByEmail(anyString())).thenReturn(null);

        List<Student> response = studentUseCase.save(students);

        verify(fileUseCase).read(students);
        verify(studentRepository).findByEmail(anyString());
    }

    @Test
    void findByEmail() {
        Student student = TestBuilder.student();
        when(studentRepository.findByEmail(anyString())).thenReturn(student);

        Student response = studentUseCase.findByEmail(student.getEmail());

        assertEquals(student, response);
        verify(studentRepository).findByEmail(anyString());
    }

    @Test
    void remove() {
        Student student = TestBuilder.student();

        studentUseCase.remove(student.getEmail());

        verify(studentRepository).remove(anyString());
    }

    @Test
    void findByCode() {
        Student student = TestBuilder.student();
        when(studentRepository.findByCode(anyString())).thenReturn(student);

        Student response = studentUseCase.findByCode(student.getCode());

        assertEquals(student, response);
        verify(studentRepository).findByCode(anyString());
    }
}