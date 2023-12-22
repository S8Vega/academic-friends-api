package co.com.ufps.model.student;

import co.com.ufps.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {
    private String semester;

    public static Student fromMap(Map<String, Object> map) {
        Student student = new Student();
        student.setEmail((String) map.get("email"));
        student.setName((String) map.get("name"));
        student.setCode(String.valueOf(Double.valueOf(map.get("code").toString()).intValue()));
        student.setType("student");
        student.setSemester(String.valueOf(Double.valueOf(map.get("semester").toString()).intValue()));
        return student;
    }
}
