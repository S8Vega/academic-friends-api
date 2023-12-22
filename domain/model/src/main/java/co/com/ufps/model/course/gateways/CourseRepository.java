package co.com.ufps.model.course.gateways;

import co.com.ufps.model.course.Course;

public interface CourseRepository {
    Course save(Course course);
}
