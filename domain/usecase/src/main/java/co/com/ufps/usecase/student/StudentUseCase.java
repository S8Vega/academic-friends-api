package co.com.ufps.usecase.student;

import co.com.ufps.model.student.Student;
import co.com.ufps.model.student.gateways.StudentRepository;
import co.com.ufps.usecase.file.FileUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class StudentUseCase {
    private final FileUseCase fileUseCase;
    private final StudentRepository studentRepository;

    public List<Student> save(Object students) {
        List<Map<String, Object>> studentsMap = fileUseCase.read(students);
        List<Student> studentsList = studentsMap.stream()
                .map(Student::fromMap)
                .toList();
        studentsList.forEach(studentRepository::save);
        return studentsList;
    }
}
