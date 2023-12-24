package co.com.ufps.director;

import co.com.ufps.director.requestbody.SaveDirectorRequestBody;
import co.com.ufps.model.user.User;
import co.com.ufps.usecase.security.SecurityUseCase;
import co.com.ufps.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/director", produces = MediaType.APPLICATION_JSON_VALUE)
public class DirectorRest {
    private final UserUseCase userUseCase;
    private final SecurityUseCase securityUseCase;

    @PostMapping
    public ResponseEntity<User> save(@RequestHeader("Authorization") String jwt,
                                     @RequestBody SaveDirectorRequestBody requestBody) throws IOException {
        log.info("save director: {}", requestBody.getEmail());
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(userUseCase.save(requestBody.toUser(), requestBody.getPassword()));
    }
}
