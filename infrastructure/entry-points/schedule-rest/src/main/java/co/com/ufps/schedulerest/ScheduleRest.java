package co.com.ufps.schedulerest;

import co.com.ufps.model.user.User;
import co.com.ufps.schedulerest.requestbody.SaveScheduleRequestBody;
import co.com.ufps.schedulerest.requestbody.UpdateScheduleRequestBody;
import co.com.ufps.schedulerest.responsebody.ScheduleResponseBody;
import co.com.ufps.usecase.schedule.ScheduleUseCase;
import co.com.ufps.usecase.security.SecurityUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SignatureException;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/schedule", produces = MediaType.APPLICATION_JSON_VALUE)
public class ScheduleRest {
    private final ScheduleUseCase scheduleUseCase;
    private final SecurityUseCase securityUseCase;

    @PostMapping
    public ResponseEntity<ScheduleResponseBody> save(@RequestHeader("Authorization") String jwt,
                                                     @RequestBody SaveScheduleRequestBody requestBody) throws SignatureException {
        log.info("save: {}", requestBody);
        securityUseCase.validate(jwt, User.Constants.COORDINATOR, User.Constants.DIRECTOR);
        return ResponseEntity.ok(ScheduleResponseBody.of(scheduleUseCase.save(requestBody.getAcademicFriendEmail(),
                requestBody.getDay(), requestBody.getStartTime(), requestBody.getEndTime())));
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseBody>> findAll(@RequestHeader("Authorization") String jwt) {
        log.info("findAll");
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(ScheduleResponseBody.of(scheduleUseCase.findAll()));
    }

    @PutMapping
    public ResponseEntity<ScheduleResponseBody> update(@RequestHeader("Authorization") String jwt,
                                                       @RequestBody UpdateScheduleRequestBody requestBody) throws SignatureException {
        log.info("update: {}", requestBody);
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(ScheduleResponseBody.of(scheduleUseCase.update(requestBody.getId(),
                requestBody.getStatus())));
    }
}
