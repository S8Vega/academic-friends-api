package co.com.ufps.jpa.repository;

import co.com.ufps.jpa.crudrepository.StudentCrudRepository;
import co.com.ufps.jpa.entities.StudentEntity;
import co.com.ufps.jpa.helper.AdapterOperations;
import co.com.ufps.model.consultancy.gateways.ConsultancyRepository;
import co.com.ufps.model.student.Student;
import co.com.ufps.model.student.gateways.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class StudentRepositoryAdapter extends AdapterOperations<Student, StudentEntity, String, StudentCrudRepository>
        implements StudentRepository {

    @Autowired
    private ConsultancyRepository consultancyRepository;

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
        log.info("Saving student: {}", student.getEmail());
        StudentEntity studentEntity = mapper.map(student, StudentEntity.class);
        return mapper.map(repository.save(studentEntity), Student.class);
    }

    @Override
    public Student findByEmail(String email) {
        log.info("Finding student with email: {}", email);
        StudentEntity studentEntity = repository.findByEmail(email);
        return (studentEntity == null ? null : mapper.map(studentEntity, Student.class));
    }

    @Override
    @Transactional
    public void remove(Student student) {
        log.info("Removing student with email: {}", student.getEmail());
        consultancyRepository.delete(student.getConsultanciesReceived());
        student.setConsultanciesReceived(null);
        StudentEntity studentEntity = mapper.map(student, StudentEntity.class);
        repository.delete(studentEntity);
    }

    @Override
    public Student findByCode(String code) {
        log.info("Finding student with code: {}", code);
        StudentEntity studentEntity = repository.findByCode(code);
        return (studentEntity == null ? null : mapper.map(studentEntity, Student.class));
    }
}
