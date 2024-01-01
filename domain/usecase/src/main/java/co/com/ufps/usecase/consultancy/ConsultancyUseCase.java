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
}
