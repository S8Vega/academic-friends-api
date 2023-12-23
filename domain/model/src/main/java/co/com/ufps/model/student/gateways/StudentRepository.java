package co.com.ufps.model.student.gateways;

import co.com.ufps.model.student.Student;

public interface StudentRepository {
    Student save(Student student);

    Student findByEmail(String email);

    void remove(String email);
}
