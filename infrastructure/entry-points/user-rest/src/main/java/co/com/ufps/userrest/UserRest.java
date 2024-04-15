package co.com.ufps.userrest;


import co.com.ufps.model.user.User;
import co.com.ufps.usecase.security.SecurityUseCase;
import co.com.ufps.usecase.user.UserUseCase;
import co.com.ufps.userrest.requestbody.ResetPasswordRequestBody;
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

import java.io.IOException;
import java.security.SignatureException;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRest {
    private final UserUseCase userUseCase;
    private final SecurityUseCase securityUseCase;

    @GetMapping("/{email}")
    public User findByEmail(@RequestHeader("Authorization") String jwt, @PathVariable String email) {
        log.info("findByEmail: {}", email);
        securityUseCase.validate(jwt);
        return userUseCase.findByEmail(email);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@RequestHeader("Authorization") String jwt,
                                              @RequestBody ResetPasswordRequestBody requestBody)
            throws IOException, SignatureException {
        securityUseCase.validate(jwt);
        userUseCase.resetPassword(requestBody.getEmail(), requestBody.getPassword());
        return ResponseEntity.ok().build();
    }
}
