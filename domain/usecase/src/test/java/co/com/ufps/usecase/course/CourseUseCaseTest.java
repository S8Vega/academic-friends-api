package co.com.ufps.usecase.course;

import co.com.ufps.model.course.Course;
import co.com.ufps.model.course.gateways.CourseRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseUseCaseTest {
    @InjectMocks
    private CourseUseCase courseUseCase;
    @Mock
    private FileUseCase fileUseCase;
    @Mock
    private CourseRepository courseRepository;

    @Test
    void save() {
        Object students = new Object();
        when(fileUseCase.read(students)).thenReturn(List.of(Map.of("code", 8.3254234E7, "credits", 3.0, "name", "Analisis de algoritmos", "semester", 4.0),
                Map.of("code", 2131232.0, "credits", 3.0, "name", "Estructuras de datos", "semester", 3.0),
                Map.of("code", 1234532.0, "credits", 4.0, "name", "Calculo II", "semester", 2.0),
                Map.of("code", 2354534.0, "credits", 8.0, "name", "Arquitectura de software", "semester", 3.0)));
        when(courseRepository.save(any(Course.class))).thenReturn(TestBuilder.course());

        List<Course> courses = courseUseCase.save(students);

        assertEquals(4, courses.size());
        assertEquals("Analisis de algoritmos", courses.get(0).getName());
        assertEquals("Estructuras de datos", courses.get(1).getName());
        assertEquals("Calculo II", courses.get(2).getName());
        assertEquals("Arquitectura de software", courses.get(3).getName());
    }

    @Test
    void findByName() {
        Course course = TestBuilder.course();
        when(courseRepository.findByName(course.getName())).thenReturn(List.of(course));

        List<Course> courses = courseUseCase.findByName(course.getName());

        assertEquals(1, courses.size());
        assertEquals(course.getName(), courses.get(0).getName());
    }

    @Test
    void findAll() {
        Course course = TestBuilder.course();
        when(courseRepository.findAll()).thenReturn(List.of(course));

        List<Course> courses = courseUseCase.findAll();

        assertEquals(1, courses.size());
        assertEquals(course.getName(), courses.get(0).getName());
    }
}