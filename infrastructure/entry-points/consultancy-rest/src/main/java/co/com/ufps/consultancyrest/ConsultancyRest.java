package co.com.ufps.consultancyrest;

import co.com.ufps.consultancyrest.requestbody.SaveConsultancyRequestBody;
import co.com.ufps.consultancyrest.responsebody.ConsultancyResponseBody;
import co.com.ufps.model.consultancy.CountConsultanciesBetweenDateRanges;
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
import java.time.LocalDateTime;
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

    @GetMapping("/count-between-date-ranges")
    public ResponseEntity<CountConsultanciesBetweenDateRanges> countBetweenDateRanges(
            @RequestHeader("Authorization") String jwt) {
        log.info("findByStartDateBetween");
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(consultancyUseCase.countBetweenDateRanges());
    }

    @GetMapping("/find-between-dates/{startDate}/{endDate}")
    public ResponseEntity<List<ConsultancyResponseBody>> findBetweenDates(
            @RequestHeader("Authorization") String jwt,
            @PathVariable String startDate,
            @PathVariable String endDate) {
        log.info("findBetweenDates: {} - {}", startDate, endDate);
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(ConsultancyResponseBody.from(consultancyUseCase.findByStartDateBetween(
                LocalDateTime.parse(startDate), LocalDateTime.parse(endDate))));
    }

    @GetMapping("/find-by-course/{courseName}")
    public ResponseEntity<List<ConsultancyResponseBody>> findByCourse(
            @RequestHeader("Authorization") String jwt,
            @PathVariable String courseName) {
        log.info("findByCourse: {}", courseName);
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(ConsultancyResponseBody.from(consultancyUseCase.findByCourse(courseName)));
    }

    @GetMapping("/find-by-course-and-between-dates/{courseName}/{startDate}/{endDate}")
    public ResponseEntity<List<ConsultancyResponseBody>> findByCourseAndBetweenDates(
            @RequestHeader("Authorization") String jwt,
            @PathVariable String courseName,
            @PathVariable String startDate,
            @PathVariable String endDate) {
        log.info("findByCourseAndBetweenDates: {} - {} - {}", courseName, startDate, endDate);
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(ConsultancyResponseBody.from(consultancyUseCase.findByCourseAndBetweenDates(
                courseName, LocalDateTime.parse(startDate), LocalDateTime.parse(endDate))));
    }
}
