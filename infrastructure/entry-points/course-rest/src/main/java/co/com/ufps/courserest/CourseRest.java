package co.com.ufps.courserest;

import co.com.ufps.courserest.responsebody.CourseCountConsultanciesResponseBody;
import co.com.ufps.courserest.responsebody.CourseResponseBody;
import co.com.ufps.model.user.User;
import co.com.ufps.usecase.course.CourseUseCase;
import co.com.ufps.usecase.security.SecurityUseCase;
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
@RequestMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseRest {
    private final CourseUseCase courseUseCase;
    private final SecurityUseCase securityUseCase;

    @PostMapping
    public ResponseEntity<List<CourseResponseBody>> save(@RequestParam("file") MultipartFile requestBody,
                                                         @RequestHeader("Authorization") String jwt)
            throws SignatureException {
        log.info("save: {}", requestBody.getOriginalFilename());
        securityUseCase.validate(jwt, User.Constants.COORDINATOR, User.Constants.DIRECTOR);
        return ResponseEntity.ok(CourseResponseBody.of(courseUseCase.save(requestBody)));
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<List<CourseResponseBody>> findByName(@RequestHeader("Authorization") String jwt,
                                                               @PathVariable String name) throws SignatureException {
        log.info("findByName: {}", name);
        securityUseCase.validate(jwt, User.Constants.COORDINATOR, User.Constants.DIRECTOR);
        return ResponseEntity.ok(CourseResponseBody.of(courseUseCase.findByName(name)));
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseBody>> findAll(@RequestHeader("Authorization") String jwt) {
        log.info("findAll");
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(CourseResponseBody.of(courseUseCase.findAll()));
    }

    @GetMapping("/count-consultancies")
    public ResponseEntity<List<CourseCountConsultanciesResponseBody>> countConsultancies(
            @RequestHeader("Authorization") String jwt)
            throws SignatureException {
        log.info("countConsultancies");
        securityUseCase.validate(jwt, User.Constants.COORDINATOR, User.Constants.DIRECTOR);
        return ResponseEntity.ok(CourseCountConsultanciesResponseBody.of(courseUseCase.findAll())
                .stream().sorted().toList());
    }
}
