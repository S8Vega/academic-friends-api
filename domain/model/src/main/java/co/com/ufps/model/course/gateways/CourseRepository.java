package co.com.ufps.model.course.gateways;

import co.com.ufps.model.course.Course;

import java.util.List;

public interface CourseRepository {
    Course save(Course course);

    List<Course> findByName(String name);

    List<Course> findAll();
}
