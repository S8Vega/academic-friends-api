package co.com.ufps.usecase.consultancy;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.consultancy.Consultancy;
import co.com.ufps.model.consultancy.CountConsultanciesBetweenDateRanges;
import co.com.ufps.model.consultancy.gateways.ConsultancyRepository;
import co.com.ufps.model.course.Course;
import co.com.ufps.model.student.Student;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import co.com.ufps.usecase.course.CourseUseCase;
import co.com.ufps.usecase.student.StudentUseCase;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@RequiredArgsConstructor
public class ConsultancyUseCase {
    private final ConsultancyRepository repository;
    private final AcademicFriendUseCase academicFriendUseCase;
    private final StudentUseCase studentUseCase;
    private final CourseUseCase courseUseCase;

    public Consultancy save(Consultancy consultancy) {
        if (!consultancy.validDates()) {
            throw new IllegalArgumentException("Fechas invalidas");
        }

        AcademicFriend academicFriend = academicFriendUseCase.findByEmail(consultancy.getAcademicFriend().getEmail());
        if (academicFriend == null) {
            throw new IllegalArgumentException("El amigo academico no existe");
        }
        consultancy.setAcademicFriend(academicFriend);

        Student student = studentUseCase.findByCode(consultancy.getStudent().getCode());
        if (student == null) {
            throw new IllegalArgumentException("El estudiante no existe");
        }
        consultancy.setStudent(student);

        List<Course> courses = courseUseCase.findByName(consultancy.getCourse().getName());
        if (courses.isEmpty()) {
            throw new IllegalArgumentException("El curso no existe");
        }
        consultancy.setCourse(courses.get(0));

        return repository.save(consultancy);
    }

    public List<Consultancy> findByStudent(String email) {
        return repository.findByStudent(email);
    }

    public List<Consultancy> findByAcademicFriend(String email) {
        return repository.findByAcademicFriend(email);
    }

    public List<Consultancy> findByStartDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findByStartDateBetween(startDate, endDate);
    }

    public CountConsultanciesBetweenDateRanges countBetweenDateRanges() {
        LocalDateTime now = LocalDateTime.now();
        List<Consultancy> today = findByStartDateBetween(
                now.withHour(0).withMinute(0).withSecond(0),
                now.withHour(23).withMinute(59).withSecond(59));
        List<Consultancy> thisWeek = findByStartDateBetween(
                now.with(DayOfWeek.MONDAY).withHour(0).withMinute(0).withSecond(0),
                now.with(DayOfWeek.SUNDAY).withHour(23).withMinute(59).withSecond(59));
        List<Consultancy> thisMonth = findByStartDateBetween(
                now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0),
                now.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59));
        LocalDateTime firstDayOfSemester = now.getMonthValue() <= 6 ?
                now.withMonth(1).withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0) :
                now.withMonth(7).withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime lastDayOfSemester = now.getMonthValue() <= 6 ?
                now.withMonth(6).with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59) :
                now.withMonth(12).with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59);
        List<Consultancy> thisSemester = findByStartDateBetween(firstDayOfSemester, lastDayOfSemester);

        return new CountConsultanciesBetweenDateRanges(
                today.size(),
                thisWeek.size(),
                thisMonth.size(),
                thisSemester.size());
    }

    public List<Consultancy> findByCourse(String courseName) {
        return repository.findByCourse(courseName);
    }

    public List<Consultancy> findByCourseAndBetweenDates(String courseName, LocalDateTime startDate,
                                                         LocalDateTime endDate) {
        return findByStartDateBetween(startDate, endDate).stream()
                .filter(consultancy -> consultancy.getCourse().getName().equals(courseName))
                .toList();
    }
}
