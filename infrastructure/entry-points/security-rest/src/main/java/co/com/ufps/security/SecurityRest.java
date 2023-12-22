package co.com.ufps.security;

import co.com.ufps.model.user.User;
import co.com.ufps.security.requestbody.LoginRequestBody;
import co.com.ufps.security.responsebody.JWTResponseBody;
import co.com.ufps.usecase.security.SecurityUseCase;
import co.com.ufps.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/security", produces = MediaType.APPLICATION_JSON_VALUE)
public class SecurityRest {
    private final SecurityUseCase securityService;
    private final UserUseCase userService;

    @PostMapping("/login")
    public ResponseEntity<JWTResponseBody> login(@RequestBody LoginRequestBody requestBody) throws IOException {
        String jwt = securityService.login(requestBody.getEmail(), requestBody.getPassword());
        User user = userService.findByEmail(requestBody.getEmail());
        JWTResponseBody jwtResponseBody = JWTResponseBody.builder()
                .jwt(jwt)
                .email(user.getEmail())
                .name(user.getName())
                .code(user.getCode())
                .type(user.getType())
                .build();
        return ResponseEntity.ok(jwtResponseBody);
    }
}
