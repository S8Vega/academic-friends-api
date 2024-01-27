package co.com.ufps.model.student;

import co.com.ufps.model.consultancy.Consultancy;
import co.com.ufps.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {
    private String semester;
    private List<Consultancy> consultanciesReceived;

    public static Student fromMap(Map<String, Object> map) {
        Student student = new Student();
        student.setEmail((String) map.get("email"));
        student.setName((String) map.get("name"));
        student.setCode(String.valueOf(Double.valueOf(map.get("code").toString()).intValue()));
        student.setType(User.Constants.STUDENT);
        student.setSemester(String.valueOf(Double.valueOf(map.get("semester").toString()).intValue()));
        student.setConsultanciesReceived(new ArrayList<>());
        return student;
    }
}
