package co.com.ufps.schedulerest;

import co.com.ufps.schedulerest.requestbody.AcademicFriendRequestBody;
import co.com.ufps.schedulerest.requestbody.SaveScheduleRequestBody;
import co.com.ufps.schedulerest.responsebody.ScheduleResponseBody;
import co.com.ufps.usecase.schedule.ScheduleUseCase;
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

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/schedule", produces = MediaType.APPLICATION_JSON_VALUE)
public class ScheduleRest {
    private final ScheduleUseCase scheduleUseCase;
    private final SecurityUseCase securityUseCase;

    @PostMapping
    public ResponseEntity<Void> save(@RequestHeader("Authorization") String jwt,
                                     @RequestBody SaveScheduleRequestBody requestBody) {
        log.info("save: {}", requestBody);
        securityUseCase.validate(jwt);
        scheduleUseCase.save(requestBody.getClassroom(),
                requestBody.getDay(), requestBody.getStartTime(), requestBody.getEndTime());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ScheduleResponseBody> findAll(@RequestHeader("Authorization") String jwt) {
        log.info("findAll");
        return ResponseEntity.ok(ScheduleResponseBody.of(scheduleUseCase.findAll()));
    }

    @GetMapping("/find-by-academic-friend/{academicFriendEmail}")
    public ResponseEntity<ScheduleResponseBody> findByAcademicFriend(
            @RequestHeader("Authorization") String jwt,
            @PathVariable String academicFriendEmail) {
        log.info("findByAcademicFriend: {}", academicFriendEmail);
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(ScheduleResponseBody.of(scheduleUseCase.findByAcademicFriend(academicFriendEmail)));
    }

    @PostMapping("/add-academic-friend")
    public ResponseEntity<Void> addAcademicFriend(@RequestHeader("Authorization") String jwt,
                                                  @RequestBody AcademicFriendRequestBody requestBody)
            throws SignatureException {
        log.info("addAcademicFriend: {}", requestBody);
        securityUseCase.validate(jwt);
        scheduleUseCase.addAcademicFriend(requestBody.getAcademicFriendEmail(), requestBody.getDay(),
                requestBody.getStartHour(), requestBody.getEndHour());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove-academic-friend")
    public ResponseEntity<Void> removeAcademicFriend(@RequestHeader("Authorization") String jwt,
                                                     @RequestBody AcademicFriendRequestBody requestBody)
            throws SignatureException {
        log.info("removeAcademicFriend: {}", requestBody);
        securityUseCase.validate(jwt);
        scheduleUseCase.removeAcademicFriend(requestBody.getAcademicFriendEmail(), requestBody.getDay(),
                requestBody.getStartHour(), requestBody.getEndHour());
        return ResponseEntity.ok().build();
    }
}
