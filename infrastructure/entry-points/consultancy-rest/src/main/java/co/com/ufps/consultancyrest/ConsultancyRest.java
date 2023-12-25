package co.com.ufps.consultancyrest;

import co.com.ufps.consultancyrest.requestbody.SaveConsultancyRequestBody;
import co.com.ufps.consultancyrest.responsebody.SaveConsultancyResponseBody;
import co.com.ufps.usecase.consultancy.ConsultancyUseCase;
import co.com.ufps.usecase.security.SecurityUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/consultancy", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsultancyRest {
    private final ConsultancyUseCase consultancyUseCase;
    private final SecurityUseCase securityUseCase;

    @PostMapping
    public ResponseEntity<SaveConsultancyResponseBody> save(@RequestHeader("Authorization") String jwt,
                                                            @RequestBody SaveConsultancyRequestBody requestBody) {
        log.info("save: {}", requestBody);
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(SaveConsultancyResponseBody.from(
                consultancyUseCase.save(requestBody.toConsultancy())));
    }
}
