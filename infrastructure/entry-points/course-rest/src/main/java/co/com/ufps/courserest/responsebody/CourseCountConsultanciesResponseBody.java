package co.com.ufps.courserest.responsebody;

import co.com.ufps.model.course.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CourseCountConsultanciesResponseBody implements Comparable<CourseCountConsultanciesResponseBody> {
    private String code;
    private String name;
    private int semester;
    private int credits;
    private int countConsultancies;

    public static CourseCountConsultanciesResponseBody of(Course course) {
        CourseCountConsultanciesResponseBody courseCountConsultanciesResponseBody = new CourseCountConsultanciesResponseBody();
        courseCountConsultanciesResponseBody.setCode(course.getCode());
        courseCountConsultanciesResponseBody.setName(course.getName());
        courseCountConsultanciesResponseBody.setSemester(course.getSemester());
        courseCountConsultanciesResponseBody.setCredits(course.getCredits());
        courseCountConsultanciesResponseBody.setCountConsultancies(course.getConsultancies().size());
        return courseCountConsultanciesResponseBody;
    }

    public static List<CourseCountConsultanciesResponseBody> of(List<Course> courses) {
        return courses.stream().map(CourseCountConsultanciesResponseBody::of).toList();
    }


    @Override
    public int compareTo(CourseCountConsultanciesResponseBody o) {
        return Integer.compare(o.countConsultancies, this.countConsultancies);
    }
}
