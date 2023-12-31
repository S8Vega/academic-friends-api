package co.com.ufps.usecase.consultancy;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.consultancy.Consultancy;
import co.com.ufps.model.consultancy.gateways.ConsultancyRepository;
import co.com.ufps.model.course.Course;
import co.com.ufps.model.student.Student;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import co.com.ufps.usecase.course.CourseUseCase;
import co.com.ufps.usecase.student.StudentUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ConsultancyUseCase {
    private final ConsultancyRepository repository;
    private final AcademicFriendUseCase academicFriendUseCase;
    private final StudentUseCase studentUseCase;
    private final CourseUseCase courseUseCase;

    public Consultancy save(Consultancy consultancy) {
        AcademicFriend academicFriend = academicFriendUseCase.findByEmail(consultancy.getAcademicFriend().getEmail());
        if (academicFriend == null) {
            throw new RuntimeException("Academic friend not found");
        }
        consultancy.setAcademicFriend(academicFriend);

        Student student = studentUseCase.findByCode(consultancy.getStudent().getCode());
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        consultancy.setStudent(student);

        Course course = courseUseCase.findByName(consultancy.getCourse().getName()).get(0);
        if (course == null) {
            throw new RuntimeException("Course not found");
        }
        consultancy.setCourse(course);

        return repository.save(consultancy);
    }

    public List<Consultancy> findByStudent(String email) {
        return repository.findByStudent(email);
    }
}
