package co.com.ufps.usecase.consultancy;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.consultancy.Consultancy;
import co.com.ufps.model.consultancy.CountConsultanciesBetweenDateRanges;
import co.com.ufps.model.consultancy.gateways.ConsultancyRepository;
import co.com.ufps.model.course.Course;
import co.com.ufps.model.student.Student;
import co.com.ufps.usecase.TestBuilder;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import co.com.ufps.usecase.course.CourseUseCase;
import co.com.ufps.usecase.student.StudentUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultancyUseCaseTest {
    @InjectMocks
    private ConsultancyUseCase consultancyUseCase;
    @Mock
    private ConsultancyRepository consultancyRepository;
    @Mock
    private AcademicFriendUseCase academicFriendUseCase;
    @Mock
    private StudentUseCase studentUseCase;
    @Mock
    private CourseUseCase courseUseCase;

    @Test
    void save() {
        Consultancy consultancy = TestBuilder.consultancy();
        consultancy.getAcademicFriend().setEmail("sebas@test.com");
        consultancy.getStudent().setCode("123456");
        consultancy.getCourse().setName("Course 1");
        when(academicFriendUseCase.findByEmail(anyString())).thenReturn(TestBuilder.academicFriend());
        when(studentUseCase.findByCode(anyString())).thenReturn(TestBuilder.student());
        when(courseUseCase.findByName(anyString())).thenReturn(Collections.singletonList(TestBuilder.course()));
        when(consultancyRepository.save(any(Consultancy.class))).thenReturn(consultancy);

        Consultancy response = consultancyUseCase.save(consultancy);

        assertEquals(consultancy, response);
        verify(consultancyRepository).save(any(Consultancy.class));
        verify(academicFriendUseCase).findByEmail(anyString());
        verify(studentUseCase).findByCode(anyString());
        verify(courseUseCase).findByName(anyString());
    }

    @Test
    void saveInvalidDates() {
        Consultancy consultancy = TestBuilder.consultancy();
        consultancy.setStartDate(LocalDateTime.now().plusDays(1));
        consultancy.setEndDate(LocalDateTime.now());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            consultancyUseCase.save(consultancy);
        });

        assertEquals("Fechas invalidas", exception.getMessage());
    }

    @Test
    void saveAcademicFriendNotFound() {
        Consultancy consultancy = TestBuilder.consultancy();
        consultancy.getAcademicFriend().setEmail("test@test.com");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            consultancyUseCase.save(consultancy);
        });

        assertEquals("El amigo academico no existe", exception.getMessage());
        verify(academicFriendUseCase).findByEmail(anyString());
    }

    @Test
    void saveStudentNotFound() {
        Consultancy consultancy = TestBuilder.consultancy();
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Student student = TestBuilder.student();
        consultancy.setAcademicFriend(academicFriend);
        consultancy.setStudent(student);
        when(academicFriendUseCase.findByEmail(anyString())).thenReturn(academicFriend);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            consultancyUseCase.save(consultancy);
        });

        assertEquals("El estudiante no existe", exception.getMessage());
        verify(academicFriendUseCase).findByEmail(anyString());
        verify(studentUseCase).findByCode(anyString());
    }

    @Test
    void saveCourseNotFound() {
        Consultancy consultancy = TestBuilder.consultancy();
        AcademicFriend academicFriend = TestBuilder.academicFriend();
        Student student = TestBuilder.student();
        Course course = TestBuilder.course();
        consultancy.setAcademicFriend(academicFriend);
        consultancy.setStudent(student);
        consultancy.setCourse(course);
        when(academicFriendUseCase.findByEmail(anyString())).thenReturn(academicFriend);
        when(studentUseCase.findByCode(anyString())).thenReturn(student);
        when(courseUseCase.findByName(anyString())).thenReturn(Collections.emptyList());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            consultancyUseCase.save(consultancy);
        });

        assertEquals("El curso no existe", exception.getMessage());
        verify(academicFriendUseCase).findByEmail(anyString());
        verify(studentUseCase).findByCode(anyString());
        verify(courseUseCase).findByName(anyString());
    }

    @Test
    void findByStudent() {
        Consultancy consultancy = TestBuilder.consultancy();
        when(consultancyRepository.findByStudent(anyString())).thenReturn(Collections.singletonList(consultancy));

        List<Consultancy> response = consultancyUseCase.findByStudent("sebas@test.com");

        assertEquals(Collections.singletonList(consultancy), response);
        verify(consultancyRepository).findByStudent(anyString());
    }

    @Test
    void findByAcademicFriend() {
        Consultancy consultancy = TestBuilder.consultancy();
        when(consultancyRepository.findByAcademicFriend(anyString())).thenReturn(Collections.singletonList(consultancy));

        List<Consultancy> response = consultancyUseCase.findByAcademicFriend("sebas@test.com");

        assertEquals(Collections.singletonList(consultancy), response);
        verify(consultancyRepository).findByAcademicFriend(anyString());
    }

    @Test
    void findByStartDateBetween() {
        Consultancy consultancy = TestBuilder.consultancy();
        when(consultancyRepository.findByStartDateBetween(any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(Collections.singletonList(consultancy));

        List<Consultancy> response = consultancyUseCase.findByStartDateBetween(LocalDateTime.now(), LocalDateTime.now());

        assertEquals(Collections.singletonList(consultancy), response);
        verify(consultancyRepository).findByStartDateBetween(any(LocalDateTime.class), any(LocalDateTime.class));
    }

    @Test
    void countBetweenDateRanges() {
        Consultancy consultancy = TestBuilder.consultancy();
        when(consultancyRepository.findByStartDateBetween(any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(Collections.singletonList(consultancy));

        CountConsultanciesBetweenDateRanges response = consultancyUseCase.countBetweenDateRanges();

        assertEquals(1, response.getDay());
        assertEquals(1, response.getWeek());
        assertEquals(1, response.getMonth());
        assertEquals(1, response.getSemester());
    }

    @Test
    void findByCourse() {
        Consultancy consultancy = TestBuilder.consultancy();
        when(consultancyRepository.findByCourse(anyString())).thenReturn(Collections.singletonList(consultancy));

        List<Consultancy> response = consultancyUseCase.findByCourse("Course 1");

        assertEquals(Collections.singletonList(consultancy), response);
        verify(consultancyRepository).findByCourse(anyString());
    }

    @Test
    void findByCourseAndBetweenDates() {
        Consultancy consultancy = TestBuilder.consultancy();
        consultancy.setCourse(TestBuilder.course());
        when(consultancyRepository.findByStartDateBetween(any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(Collections.singletonList(consultancy));

        List<Consultancy> response = consultancyUseCase.findByCourseAndBetweenDates(consultancy.getCourse().getName(),
                LocalDateTime.now(), LocalDateTime.now());

        assertEquals(Collections.singletonList(consultancy), response);
        verify(consultancyRepository).findByStartDateBetween(any(LocalDateTime.class), any(LocalDateTime.class));
    }
}