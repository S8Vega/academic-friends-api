package co.com.ufps.security;

import co.com.ufps.model.user.User;
import co.com.ufps.security.requestbody.EmailRequestBody;
import co.com.ufps.security.requestbody.LoginRequestBody;
import co.com.ufps.security.requestbody.ResetPasswordRequestBody;
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
import java.security.SignatureException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/security", produces = MediaType.APPLICATION_JSON_VALUE)
public class SecurityRest {
    private final SecurityUseCase securityService;
    private final UserUseCase userService;

    @PostMapping("/login")
    public ResponseEntity<JWTResponseBody> login(@RequestBody LoginRequestBody requestBody) throws IOException {
        User user = userService.findByEmail(requestBody.getEmail());
        String jwt = securityService.login(requestBody.getEmail(), requestBody.getPassword(), user.getType());
        JWTResponseBody jwtResponseBody = JWTResponseBody.builder()
                .jwt(jwt)
                .email(user.getEmail())
                .name(user.getName())
                .code(user.getCode())
                .type(user.getType())
                .build();
        return ResponseEntity.ok(jwtResponseBody);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody EmailRequestBody requestBody) throws IOException, SignatureException {
        securityService.forgotPassword(requestBody.getEmail());
        return ResponseEntity.ok("Se ha enviado un correo para restablecer la contraseña");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequestBody requestBody) throws IOException, SignatureException {
        securityService.resetPassword(requestBody.getEmail(), requestBody.getPassword(), requestBody.getCode());
        return ResponseEntity.ok("Se ha restablecido la contraseña");
    }
}
