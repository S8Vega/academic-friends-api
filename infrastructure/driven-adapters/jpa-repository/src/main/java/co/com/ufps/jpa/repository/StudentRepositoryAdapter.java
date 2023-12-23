package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.StudentCrudRepository;
import co.com.ufps.jpa.entities.StudentEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.student.Student;
import co.com.ufps.model.student.gateways.StudentRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryAdapter extends AdapterOperations<Student, StudentEntity, String, StudentCrudRepository>
        implements StudentRepository {

    public StudentRepositoryAdapter(StudentCrudRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Student.class));
    }

    @Override
    public Student save(Student student) {
        StudentEntity studentEntity = mapper.map(student, StudentEntity.class);
        return mapper.map(repository.save(studentEntity), Student.class);
    }

    @Override
    public Student findByEmail(String email) {
        StudentEntity studentEntity = repository.findByEmail(email);
        return mapper.map(studentEntity, Student.class);
    }

    @Override
    public void remove(String email) {
        StudentEntity studentEntity = repository.findByEmail(email);
        repository.delete(studentEntity);
    }
}
