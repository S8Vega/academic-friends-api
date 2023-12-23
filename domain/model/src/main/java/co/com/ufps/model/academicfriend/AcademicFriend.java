package co.com.ufps.model.academicfriend;

import co.com.ufps.model.convocation.Convocation;
import co.com.ufps.model.student.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AcademicFriend extends Student {
    private String status; // (pass, pending, rejected)
    private String resume;
    private int score;
    private Double average;
    private Convocation convocation;
    private String observations;
    private String classSchedule;
}
