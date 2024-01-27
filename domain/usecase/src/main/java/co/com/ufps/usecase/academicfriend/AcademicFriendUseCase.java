package co.com.ufps.usecase.academicfriend;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.academicfriend.gateways.AcademicFriendRepository;
import co.com.ufps.model.convocation.Convocation;
import co.com.ufps.model.exceptions.ConvocationNotFoundException;
import co.com.ufps.model.exceptions.UserNotFoundException;
import co.com.ufps.model.student.Student;
import co.com.ufps.model.user.User;
import co.com.ufps.usecase.convocation.ConvocationUseCase;
import co.com.ufps.usecase.file.FileUseCase;
import co.com.ufps.usecase.security.SecurityUseCase;
import co.com.ufps.usecase.student.StudentUseCase;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class AcademicFriendUseCase {
    private static final String CONTRACT_FOLDER = "contract";
    private static final String RESUME_FOLDER = "resume";
    private static final String USER_NOT_FOUND = "El usuario %s no existe";
    private final AcademicFriendRepository academicFriendRepository;
    private final FileUseCase fileUseCase;
    private final StudentUseCase studentUseCase;
    private final ConvocationUseCase convocationUseCase;
    private final SecurityUseCase securityUseCase;

    public AcademicFriend apply(AcademicFriend academicFriend, File resume) {
        Student student = studentUseCase.findByEmail(academicFriend.getEmail());

        if (student == null) {
            throw new UserNotFoundException(String.format(USER_NOT_FOUND, academicFriend.getEmail()));
        }

        buildAcademicFriend(academicFriend, student);
        fileUseCase.save(academicFriend.getResume(), resume);

        if (!student.getType().equals(User.Constants.ACADEMIC_FRIEND)) {
            studentUseCase.remove(academicFriend.getEmail());
        }

        return academicFriendRepository.apply(academicFriend);
    }

    private void buildAcademicFriend(AcademicFriend academicFriend, Student student) {
        academicFriend.setName(student.getName());
        academicFriend.setCode(student.getCode());
        academicFriend.setType(student.getType());
        academicFriend.setSemester(student.getSemester());
        academicFriend.setStatus(AcademicFriend.Constants.PENDING);
        academicFriend.setResume(String.format("%s/%s.pdf", RESUME_FOLDER, academicFriend.getEmail()));
        academicFriend.setScore(0);
        academicFriend.setConsultanciesReceived(student.getConsultanciesReceived());
        Convocation convocation = convocationUseCase.findCurrentConvocation();
        if (convocation == null) {
            throw new ConvocationNotFoundException("La convocatoria no existe");
        }
        academicFriend.setConvocation(convocation);
        academicFriend.setObservations("");
    }

    public List<AcademicFriend> findAll() {
        List<AcademicFriend> academicFriends = academicFriendRepository.findAll();
        Collections.sort(academicFriends);
        return academicFriends;
    }

    public AcademicFriend findByEmail(String email) {
        return academicFriendRepository.findByEmail(email);
    }

    public AcademicFriend update(String email, int score, String observations, String state, String password)
            throws IOException {
        AcademicFriend academicFriend = academicFriendRepository.findByEmail(email);
        if (academicFriend == null) {
            throw new UserNotFoundException(String.format(USER_NOT_FOUND, email));
        }
        academicFriend.setScore(score);
        academicFriend.setObservations(observations);
        if (!AcademicFriend.Constants.STATUS.contains(state)) {
            throw new IllegalArgumentException("Estado no valido");
        }
        academicFriend.setStatus(state);
        if (state.equals(AcademicFriend.Constants.PASS)) {
            academicFriend.setType(User.Constants.ACADEMIC_FRIEND);
            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException("La contraseña es obligatoria");
            }
            securityUseCase.save(email, password, User.Constants.ACADEMIC_FRIEND);
        }
        if (state.equals(AcademicFriend.Constants.REJECTED)) {
            securityUseCase.delete(email);
        }
        return academicFriendRepository.update(academicFriend);
    }

    public void addContract(String email, File contract) {
        AcademicFriend academicFriend = academicFriendRepository.findByEmail(email);
        if (academicFriend == null) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        academicFriend.setContract(String.format("%s/%s.pdf", CONTRACT_FOLDER, academicFriend.getEmail()));
        fileUseCase.save(academicFriend.getContract(), contract);
        academicFriendRepository.update(academicFriend);
    }

    public List<AcademicFriend> findByConvocation(Long id) {
        return academicFriendRepository.findByConvocation(id);
    }

    public AcademicFriend findByCode(String code) {
        return academicFriendRepository.findByCode(code);
    }
}
