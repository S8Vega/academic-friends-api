package co.com.ufps.model.consultancy;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.course.Course;
import co.com.ufps.model.student.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
public class Consultancy {
    private Long id;
    private AcademicFriend academicFriend;
    private Student student;
    private Course course;
    private LocalDateTime creationDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String difficultiesEncountered;
    private String aspectsToImprove;
}
