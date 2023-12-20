package co.com.ufps.security;

import co.com.ufps.security.requestbody.LoginRequestBody;
import co.com.ufps.usecase.security.SecurityUseCase;
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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestBody requestBody) throws IOException {
        return ResponseEntity.ok(securityService.login(requestBody.getEmail(), requestBody.getPassword()));
    }
}
