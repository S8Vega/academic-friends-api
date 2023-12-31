package co.com.ufps.convocationrest;

import co.com.ufps.convocationrest.requestbody.SaveConvocationRequestBody;
import co.com.ufps.convocationrest.responsebody.ConvocationResponseBody;
import co.com.ufps.model.user.User;
import co.com.ufps.usecase.convocation.ConvocationUseCase;
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
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/convocation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConvocationRest {
    private final ConvocationUseCase convocationUseCase;
    private final SecurityUseCase securityUseCase;

    @PostMapping
    public ResponseEntity<ConvocationResponseBody> save(@RequestHeader("Authorization") String jwt,
                                                        @RequestBody SaveConvocationRequestBody requestBody)
            throws SignatureException {
        log.info("save convocation: {}", requestBody);
        securityUseCase.validate(jwt, User.Constants.COORDINATOR, User.Constants.DIRECTOR);
        return ResponseEntity.ok(ConvocationResponseBody.from(convocationUseCase.save(requestBody.toConvocation())));
    }

    @GetMapping
    public ResponseEntity<List<ConvocationResponseBody>> findAll(@RequestHeader("Authorization") String jwt)
            throws SignatureException {
        log.info("find all convocation");
        securityUseCase.validate(jwt, User.Constants.COORDINATOR, User.Constants.DIRECTOR);
        return ResponseEntity.ok(ConvocationResponseBody.from(convocationUseCase.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConvocationResponseBody> findById(@RequestHeader("Authorization") String jwt, @PathVariable Long id)
            throws SignatureException {
        log.info("find convocation by id: {}", id);
        securityUseCase.validate(jwt, User.Constants.COORDINATOR, User.Constants.DIRECTOR);
        return ResponseEntity.ok(ConvocationResponseBody.from(convocationUseCase.findById(id)));
    }

    @GetMapping("/active")
    public ResponseEntity<ConvocationResponseBody> findActive(@RequestHeader("Authorization") String jwt)
            throws SignatureException {
        log.info("find active convocation");
        securityUseCase.validate(jwt, User.Constants.COORDINATOR, User.Constants.DIRECTOR);
        return ResponseEntity.ok(ConvocationResponseBody.from(convocationUseCase.findCurrentConvocation()));
    }
}
