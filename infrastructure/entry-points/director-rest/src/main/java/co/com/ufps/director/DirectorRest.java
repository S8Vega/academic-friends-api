package co.com.ufps.director;

import co.com.ufps.director.requestbody.SaveDirectorRequestBody;
import co.com.ufps.model.user.User;
import co.com.ufps.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/director", produces = MediaType.APPLICATION_JSON_VALUE)
public class DirectorRest {
    private final UserUseCase userUseCase;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody SaveDirectorRequestBody requestBody) {
        return ResponseEntity.ok(userUseCase.save(requestBody.toUser(), requestBody.getPassword()));
    }
}
