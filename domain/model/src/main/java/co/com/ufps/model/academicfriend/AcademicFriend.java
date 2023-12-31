package co.com.ufps.model.academicfriend;

import co.com.ufps.model.convocation.Convocation;
import co.com.ufps.model.student.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AcademicFriend extends Student implements Comparable<AcademicFriend> {
    private String status; // (pass, pending, rejected)
    private String resume;
    private int score;
    private Double average;
    private Convocation convocation;
    private String observations;
    private String classSchedule;

    @Override
    public int compareTo(AcademicFriend o) {
        return o.getScore() - this.getScore();
    }

    public class Constants {
        public static final String PASS = "pass";
        public static final String PENDING = "pending";
        public static final String REJECTED = "rejected";

        public static final List<String> STATUS = List.of(PASS, PENDING, REJECTED);
    }
}
