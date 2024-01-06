package co.com.ufps.academicfriendrest;

import co.com.ufps.academicfriendrest.requestbody.ResetPasswordRequestBody;
import co.com.ufps.academicfriendrest.responsebody.AcademicFriendResponseBody;
import co.com.ufps.academicfriendrest.responsebody.UpdateAcademicFriendRequestBody;
import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.model.user.User;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import co.com.ufps.usecase.security.SecurityUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SignatureException;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/academic-friend", produces = MediaType.APPLICATION_JSON_VALUE)
public class AcademicFriendRest {
    public static final int SIZE_BUFFER = 10000;
    private final AcademicFriendUseCase academicFriendUseCase;
    private final SecurityUseCase securityUseCase;

    public static File convert(MultipartFile multipartFile) throws IOException {
        byte[] content = multipartFile.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
        File file = File.createTempFile(multipartFile.getOriginalFilename(), null);
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[SIZE_BUFFER];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        return file;
    }

    @PostMapping
    public ResponseEntity<AcademicFriendResponseBody> save(
            @RequestPart MultipartFile resume, @RequestPart String email, @RequestPart String average)
            throws IOException {
        AcademicFriend academicFriend = new AcademicFriend();
        academicFriend.setEmail(email);
        academicFriend.setAverage(Double.parseDouble(average));
        return ResponseEntity.ok(
                AcademicFriendResponseBody.from(
                        academicFriendUseCase.save(academicFriend, convert(resume))));
    }

    @GetMapping
    public ResponseEntity<List<AcademicFriendResponseBody>> findAll(@RequestHeader("Authorization") String jwt)
            throws SignatureException {
        securityUseCase.validate(jwt, User.Constants.DIRECTOR, User.Constants.COORDINATOR);
        return ResponseEntity.ok(AcademicFriendResponseBody.from(academicFriendUseCase.findAll()));
    }

    @PutMapping
    public ResponseEntity<AcademicFriendResponseBody> update(
            @RequestHeader("Authorization") String jwt,
            @RequestBody UpdateAcademicFriendRequestBody requestBody) throws SignatureException, IOException {
        log.info("update: {}", requestBody.getEmail());
        securityUseCase.validate(jwt, User.Constants.DIRECTOR, User.Constants.COORDINATOR);
        return ResponseEntity.ok(AcademicFriendResponseBody.from(
                academicFriendUseCase.update(requestBody.getEmail(), requestBody.getScore(),
                        requestBody.getObservations(), requestBody.getState(), requestBody.getPassword())));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<AcademicFriendResponseBody> resetPassword(@RequestHeader("Authorization") String jwt,
                                                                    @RequestBody ResetPasswordRequestBody requestBody)
            throws IOException, SignatureException {
        securityUseCase.validate(jwt, User.Constants.DIRECTOR, User.Constants.COORDINATOR);
        academicFriendUseCase.resetPassword(requestBody.getEmail(), requestBody.getPassword());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/contract")
    public ResponseEntity<AcademicFriendResponseBody> updateContract(
            @RequestHeader("Authorization") String jwt,
            @RequestPart MultipartFile contract, @RequestPart String email) throws IOException, SignatureException {
        securityUseCase.validate(jwt, User.Constants.DIRECTOR, User.Constants.COORDINATOR);
        academicFriendUseCase.addContract(email, convert(contract));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find-by-convocation/{id}")
    public ResponseEntity<List<AcademicFriendResponseBody>> findByConvocation(@RequestHeader("Authorization") String jwt,
                                                                              @PathVariable Long id) throws SignatureException {
        securityUseCase.validate(jwt, User.Constants.DIRECTOR, User.Constants.COORDINATOR);
        return ResponseEntity.ok(AcademicFriendResponseBody.from(academicFriendUseCase.findByConvocation(id)));
    }

    @GetMapping("/{code}")
    public ResponseEntity<AcademicFriendResponseBody> findByCode(@RequestHeader("Authorization") String jwt,
                                                                 @PathVariable String code) throws SignatureException {
        securityUseCase.validate(jwt, User.Constants.DIRECTOR, User.Constants.COORDINATOR);
        return ResponseEntity.ok(AcademicFriendResponseBody.from(academicFriendUseCase.findByCode(code)));
    }
}
