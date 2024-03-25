package co.com.ufps.studentrest.responsebody;

import co.com.ufps.model.student.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentResponseBody {
    private String email;
    private String name;
    private String code;
    private String type;
    private String semester;

    public static StudentResponseBody of(Student student) {
        StudentResponseBody studentResponseBody = new StudentResponseBody();
        studentResponseBody.setEmail(student.getEmail());
        studentResponseBody.setName(student.getName());
        studentResponseBody.setCode(student.getCode());
        studentResponseBody.setType(student.getType());
        studentResponseBody.setSemester(student.getSemester());
        return studentResponseBody;
    }
}
