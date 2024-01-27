package co.com.ufps.model.academicfriend;

import co.com.ufps.model.consultancy.Consultancy;
import co.com.ufps.model.convocation.Convocation;
import co.com.ufps.model.exceptions.ConvocationNotFoundException;
import co.com.ufps.model.student.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class AcademicFriend extends Student implements Comparable<AcademicFriend> {
    private String status; // (pass, pending, rejected)
    private String resume;
    private int score;
    private Double average;
    private Convocation convocation;
    private String observations;
    private String contract;

    private List<Consultancy> consultanciesGiven;


    public void merge(Student student, Convocation convocation) {
        this.setName(student.getName());
        this.setCode(student.getCode());
        this.setType(student.getType());
        this.setSemester(student.getSemester());
        this.setStatus(AcademicFriend.Constants.PENDING);
        this.setResume(String.format("%s/%s.pdf", Constants.RESUME_FOLDER, this.getEmail()));
        this.setScore(0);
        this.setConsultanciesReceived(student.getConsultanciesReceived());
        if (convocation == null) {
            throw new ConvocationNotFoundException("La convocatoria no existe");
        }
        this.setConvocation(convocation);
        this.setObservations("");
    }

    public void cleanConvocation() {
        this.convocation = null;
    }

    @Override
    public int compareTo(AcademicFriend o) {
        return o.getScore() - this.getScore();
    }

    public class Constants {
        public static final String PASS = "pass";
        public static final String PENDING = "pending";
        public static final String REJECTED = "rejected";
        public static final List<String> STATUS = List.of(PASS, PENDING, REJECTED);
        private static final String RESUME_FOLDER = "resume";

        private Constants() {
            throw new IllegalStateException("Utility class");
        }
    }
}
