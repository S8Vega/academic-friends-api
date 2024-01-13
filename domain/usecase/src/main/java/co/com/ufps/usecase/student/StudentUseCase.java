package co.com.ufps.usecase.student;

import co.com.ufps.model.student.Student;
import co.com.ufps.model.student.gateways.StudentRepository;
import co.com.ufps.model.user.User;
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
                .filter(student -> student.get("email") != null && student.get("name") != null &&
                        student.get("code") != null && student.get("semester") != null)
                .map(Student::fromMap)
                .toList();
        studentsList.forEach(student -> {
            if (!student.getEmail().endsWith(User.Constants.EMAIL)) {
                throw new IllegalArgumentException(String.format("El correo %s no es valido", student.getEmail()));
            }
            if (!student.getCode().startsWith(User.Constants.CODE)) {
                throw new IllegalArgumentException(String.format("El codigo %s no es valido", student.getCode()));
            }
        });
        studentsList.forEach(student -> {
            Student current = findByEmail(student.getEmail());
            if (current == null) {
                studentRepository.save(student);
            }
        });
        return studentsList;
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public void remove(String email) {
        studentRepository.remove(email);
    }

    public Student findByCode(String code) {
        return studentRepository.findByCode(code);
    }
}
