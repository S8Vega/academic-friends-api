package co.com.ufps.studentrest;

import co.com.ufps.model.student.Student;
import co.com.ufps.model.user.User;
import co.com.ufps.usecase.security.SecurityUseCase;
import co.com.ufps.usecase.student.StudentUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.security.SignatureException;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentRest {
    private final StudentUseCase studentUseCase;
    private final SecurityUseCase securityUseCase;

    @PostMapping
    public ResponseEntity<List<Student>> save(@RequestParam("file") MultipartFile requestBody,
                                              @RequestHeader("Authorization") String jwt) throws SignatureException {
        log.info("save: {}", requestBody.getOriginalFilename());
        securityUseCase.validate(jwt, User.Constants.COORDINATOR, User.Constants.DIRECTOR);
        return ResponseEntity.ok(studentUseCase.save(requestBody));
    }

    @GetMapping("/find-by-code/{code}")
    public ResponseEntity<Student> findByCode(@RequestHeader("Authorization") String jwt,
                                              @PathVariable String code) {
        log.info("findByCode: {}", code);
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(studentUseCase.findByCode(code));
    }
}
