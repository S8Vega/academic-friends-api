package co.com.ufps.usecase;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.convocation.Convocation;
import co.com.ufps.model.student.Student;
import co.com.ufps.model.user.User;

import java.time.LocalDateTime;

public class Builder {

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
}
