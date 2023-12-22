package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.CourseCrudRepository;
import co.com.ufps.jpa.entities.CourseEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.course.Course;
import co.com.ufps.model.course.gateways.CourseRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepositoryAdapter extends AdapterOperations<Course, CourseEntity, String, CourseCrudRepository>
        implements CourseRepository {

    public CourseRepositoryAdapter(CourseCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Course.class));
    }

    @Override
    public Course save(Course course) {
        CourseEntity courseEntity = mapper.map(course, CourseEntity.class);
        return mapper.map(repository.save(courseEntity), Course.class);
    }
}
