package co.com.ufps.usecase.academicfriend;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.academicfriend.gateways.AcademicFriendRepository;
import co.com.ufps.model.convocation.Convocation;
import co.com.ufps.model.exceptions.ConvocationNotFoundException;
import co.com.ufps.model.exceptions.UserNotFoundException;
import co.com.ufps.model.student.Student;
import co.com.ufps.model.user.UserConstants;
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
    private final AcademicFriendRepository academicFriendRepository;
    private final FileUseCase fileUseCase;
    private final StudentUseCase studentUseCase;
    private final ConvocationUseCase convocationUseCase;
    private final SecurityUseCase securityUseCase;

    public AcademicFriend save(AcademicFriend academicFriend, File resume) {
        Student student = studentUseCase.findByEmail(academicFriend.getEmail());
        if (student == null) {
            throw new UserNotFoundException(String.format("User %s not found", academicFriend.getEmail()));
        } else if (student.getType().equals(UserConstants.Type.ACADEMIC_FRIEND)) {
            academicFriend = buildAcademicFriend(academicFriend, student);
            fileUseCase.save(academicFriend.getResume(), resume);
            return academicFriendRepository.save(academicFriend);
        }
        academicFriend = buildAcademicFriend(academicFriend, student);
        fileUseCase.save(academicFriend.getResume(), resume);

        studentUseCase.remove(academicFriend.getEmail());
        return academicFriendRepository.save(academicFriend);
    }

    private AcademicFriend buildAcademicFriend(AcademicFriend academicFriend, Student student) {
        academicFriend.setName(student.getName());
        academicFriend.setCode(student.getCode());
        academicFriend.setType(student.getType());
        academicFriend.setSemester(student.getSemester());
        academicFriend.setStatus(AcademicFriend.Constants.PENDING);
        academicFriend.setResume(String.format("%s/%s.pdf", RESUME_FOLDER, academicFriend.getEmail()));
        academicFriend.setScore(0);
        Convocation convocation = convocationUseCase.findCurrentConvocation();
        if (convocation == null) {
            throw new ConvocationNotFoundException("Convocation not found");
        }
        academicFriend.setConvocation(convocation);
        academicFriend.setObservations("");
        return academicFriend;
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
            throw new UserNotFoundException(String.format("User %s not found", email));
        }
        academicFriend.setScore(score);
        academicFriend.setObservations(observations);
        if (!AcademicFriend.Constants.STATUS.contains(state)) {
            throw new RuntimeException("Invalid status");
        }
        academicFriend.setStatus(state);
        if (state.equals(AcademicFriend.Constants.PASS)) {
            academicFriend.setType(UserConstants.Type.ACADEMIC_FRIEND);
            if (password == null || password.isEmpty()) {
                throw new RuntimeException("Password is required");
            }
            securityUseCase.save(email, password, UserConstants.Type.ACADEMIC_FRIEND);
        }
        if (state.equals(AcademicFriend.Constants.REJECTED)) {
            securityUseCase.delete(email);
        }
        return academicFriendRepository.save(academicFriend);
    }

    public void resetPassword(String email, String password) throws IOException {
        securityUseCase.resetPassword(email, password);
    }

    public void addContract(String email, File contract) {
        AcademicFriend academicFriend = academicFriendRepository.findByEmail(email);
        if (academicFriend == null) {
            throw new RuntimeException("User not found");
        }
        academicFriend.setContract(String.format("%s/%s.pdf", CONTRACT_FOLDER, academicFriend.getEmail()));
        fileUseCase.save(academicFriend.getContract(), contract);
        academicFriendRepository.save(academicFriend);
    }

    public List<AcademicFriend> findByConvocation(Long id) {
        return academicFriendRepository.findByConvocation(id);
    }

    public AcademicFriend findByCode(String code) {
        return academicFriendRepository.findByCode(code);
    }
}
