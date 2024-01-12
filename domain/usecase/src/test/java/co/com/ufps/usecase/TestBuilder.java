package co.com.ufps.usecase;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.consultancy.Consultancy;
import co.com.ufps.model.convocation.Convocation;
import co.com.ufps.model.course.Course;
import co.com.ufps.model.report.Report;
import co.com.ufps.model.schedule.Schedule;
import co.com.ufps.model.student.Student;
import co.com.ufps.model.user.User;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class TestBuilder {

    public static AcademicFriend academicFriend() {
        AcademicFriend academicFriend = new AcademicFriend();
        academicFriend.setEmail("sebas@test.com");
        academicFriend.setName("Sebastian");
        academicFriend.setCode("123456");
        academicFriend.setType(User.Constants.ACADEMIC_FRIEND);
        academicFriend.setSemester("10");
        academicFriend.setStatus(AcademicFriend.Constants.PENDING);
        academicFriend.setResume("resume/sebas@test.com.pdf");
        academicFriend.setScore(87);
        academicFriend.setAverage(4.5);
        academicFriend.setObservations("");
        academicFriend.setConvocation(Convocation.builder().build());
        academicFriend.setContract("contract/sebas@test.com");
        return academicFriend;
    }

    public static Student student() {
        Student student = new Student();
        student.setEmail("sebas@test.com");
        student.setName("Sebastian");
        student.setCode("123456");
        student.setType(User.Constants.STUDENT);
        student.setSemester("10");
        return student;
    }

    public static Convocation convocation() {
        return Convocation.builder()
                .id(1L)
                .closingDate(LocalDateTime.parse("2021-10-10T00:00:00"))
                .openingDate(LocalDateTime.parse("2021-09-10T00:00:00"))
                .evaluationDate(LocalDateTime.parse("2021-11-10T00:00:00"))
                .resultsReleaseDate(LocalDateTime.parse("2021-12-10T00:00:00"))
                .build();
    }

    public static Consultancy consultancy() {
        Consultancy consultancy = new Consultancy();
        consultancy.setAcademicFriend(new AcademicFriend());
        consultancy.setStudent(new Student());
        consultancy.setCourse(new Course());
        consultancy.setStartDate(LocalDateTime.parse("2021-10-10T00:00:00"));
        consultancy.setEndDate(LocalDateTime.parse("2021-10-10T00:00:00"));
        consultancy.setId(1L);
        consultancy.setAspectsToImprove("Aspectos a mejorar");
        consultancy.setDifficultiesEncountered("Dificultades encontradas");
        consultancy.setCreationDate(LocalDateTime.parse("2021-10-10T00:00:00"));
        return consultancy;
    }

    public static Course course() {
        return Course.builder()
                .code("1234")
                .name("Ingenieria de sistemas")
                .consultancies(new ArrayList<>())
                .credits(4)
                .semester(10)
                .build();
    }

    public static Schedule schedule() {
        return Schedule.builder()
                .id(1L)
                .academicFriends(new ArrayList<>())
                .day(DayOfWeek.MONDAY)
                .hour(LocalTime.parse("10:00:00"))
                .classroom("A-101")
                .build();
    }

    public static Report report() {
        return Report.builder()
                .id(1L)
                .academicFriend(new AcademicFriend())
                .date(LocalDateTime.parse("2021-10-10T00:00:00"))
                .file("file")
                .observations("Observations")
                .state(Report.Constants.STATE_PENDING)
                .type(Report.Constants.TYPE_MONTHLY)
                .uploadDate(LocalDateTime.parse("2021-10-10T00:00:00"))
                .build();
    }

    public static User user() {
        User user = new User();
        user.setEmail("test@ufps.edu.co");
        user.setCode("123456");
        user.setName("Test");
        user.setType(User.Constants.ACADEMIC_FRIEND);
        return user;
    }
}
