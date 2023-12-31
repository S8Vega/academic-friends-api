package co.com.ufps.consultancyrest;

import co.com.ufps.consultancyrest.requestbody.SaveConsultancyRequestBody;
import co.com.ufps.consultancyrest.responsebody.ConsultancyResponseBody;
import co.com.ufps.model.user.User;
import co.com.ufps.usecase.consultancy.ConsultancyUseCase;
import co.com.ufps.usecase.security.SecurityUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SignatureException;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/consultancy", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsultancyRest {
    private final ConsultancyUseCase consultancyUseCase;
    private final SecurityUseCase securityUseCase;

    @PostMapping
    public ResponseEntity<ConsultancyResponseBody> save(@RequestHeader("Authorization") String jwt,
                                                        @RequestBody SaveConsultancyRequestBody requestBody)
            throws SignatureException {
        log.info("save: {}", requestBody);
        securityUseCase.validate(jwt, User.Constants.ACADEMIC_FRIEND);
        return ResponseEntity.ok(ConsultancyResponseBody.from(
                consultancyUseCase.save(requestBody.toConsultancy())));
    }

    @GetMapping("/find-by-student/{email}")
    public ResponseEntity<List<ConsultancyResponseBody>> findByStudent(@RequestHeader("Authorization") String jwt,
                                                                       @PathVariable String email) {
        log.info("findByStudent: {}", email);
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(ConsultancyResponseBody.from(consultancyUseCase.findByStudent(email)));
    }

    @GetMapping("/find-by-academic-friend/{email}")
    public ResponseEntity<List<ConsultancyResponseBody>> findByAcademicFriend(@RequestHeader("Authorization") String jwt,
                                                                              @PathVariable String email) {
        log.info("findByAcademicFriend: {}", email);
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(ConsultancyResponseBody.from(consultancyUseCase.findByAcademicFriend(email)));
    }
}
