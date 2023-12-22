package co.com.ufps.courserest;

import co.com.ufps.model.course.Course;
import co.com.ufps.usecase.course.CourseUseCase;
import co.com.ufps.usecase.security.SecurityUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseRest {
    private final CourseUseCase courseUseCase;
    private final SecurityUseCase securityUseCase;

    @PostMapping
    public ResponseEntity<List<Course>> save(@RequestParam("file") MultipartFile requestBody,
                                             @RequestHeader("Authorization") String jwt) {
        log.info("save: {}", requestBody.getOriginalFilename());
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(courseUseCase.save(requestBody));
    }
}
