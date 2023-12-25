package co.com.ufps.consultancyrest.requestbody;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.consultancy.Consultancy;
import co.com.ufps.model.course.Course;
import co.com.ufps.model.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class SaveConsultancyRequestBody {
    private String academicFriendEmail;
    private String studentCode;
    private String courseName;
    private String startDate;
    private String endDate;
    private String difficultiesEncountered;
    private String aspectsToImprove;

    public Consultancy toConsultancy() {
        AcademicFriend academicFriend = new AcademicFriend();
        academicFriend.setEmail(academicFriendEmail);
        Student student = new Student();
        student.setCode(studentCode);
        Course course = new Course();
        course.setName(courseName);
        return Consultancy.builder()
                .academicFriend(academicFriend)
                .student(student)
                .course(course)
                .creationDate(LocalDateTime.now())
                .startDate(LocalDateTime.parse(startDate))
                .endDate(LocalDateTime.parse(endDate))
                .difficultiesEncountered(difficultiesEncountered)
                .aspectsToImprove(aspectsToImprove)
                .build();
    }
}
