package co.com.ufps.courserest.responsebody;

import co.com.ufps.model.course.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CourseResponseBody {
    private String code;
    private String name;
    private int semester;
    private int credits;

    public static CourseResponseBody of(Course course) {
        CourseResponseBody courseResponseBody = new CourseResponseBody();
        courseResponseBody.setCode(course.getCode());
        courseResponseBody.setName(course.getName());
        courseResponseBody.setSemester(course.getSemester());
        courseResponseBody.setCredits(course.getCredits());
        return courseResponseBody;
    }

    public static List<CourseResponseBody> of(List<Course> courses) {
        return courses.stream().map(CourseResponseBody::of).toList();
    }
}
