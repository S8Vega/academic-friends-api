package co.com.ufps.usecase.course;

import co.com.ufps.model.course.Course;
import co.com.ufps.model.course.gateways.CourseRepository;
import co.com.ufps.usecase.file.FileUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class CourseUseCase {
    private final FileUseCase fileUseCase;
    private final CourseRepository courseRepository;


    public List<Course> save(Object students) {
        List<Map<String, Object>> coursesMap = fileUseCase.read(students);
        List<Course> coursesList = coursesMap.stream()
                .map(Course::fromMap)
                .toList();
        coursesList.forEach(courseRepository::save);
        return coursesList;
    }
}
