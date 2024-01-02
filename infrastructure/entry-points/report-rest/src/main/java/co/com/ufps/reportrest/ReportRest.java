package co.com.ufps.reportrest;

import co.com.ufps.model.user.User;
import co.com.ufps.reportrest.requestbody.UpdateReportRequestBody;
import co.com.ufps.reportrest.responsebody.ReportResponseBody;
import co.com.ufps.usecase.report.ReportUseCase;
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
@RequestMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportRest {
    public static final int SIZE_BUFFER = 10000;
    private final ReportUseCase reportUseCase;
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
    public ResponseEntity<ReportResponseBody> save(@RequestHeader("Authorization") String jwt,
                                                   @RequestPart String academicFriend, @RequestPart String type,
                                                   @RequestPart String date, @RequestPart MultipartFile file)
            throws IOException, SignatureException {
        log.info("save: {}", academicFriend);
        securityUseCase.validate(jwt, User.Constants.ACADEMIC_FRIEND);
        return ResponseEntity.ok(ReportResponseBody.of(reportUseCase.save(academicFriend, type, date, convert(file))));
    }

    @GetMapping("/find-by-academic-friend/{academicFriend}")
    public ResponseEntity<List<ReportResponseBody>> findByAcademicFriend(@RequestHeader("Authorization") String jwt,
                                                                         @PathVariable String academicFriend)
            throws IOException, SignatureException {
        log.info("findByAcademicFriend: {}", academicFriend);
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(ReportResponseBody.of(reportUseCase.findByAcademicFriend(academicFriend)));
    }

    @PutMapping
    public ResponseEntity<ReportResponseBody> update(@RequestHeader("Authorization") String jwt,
                                                     @RequestBody UpdateReportRequestBody requestBody)
            throws IOException, SignatureException {
        log.info("update: {}", requestBody);
        securityUseCase.validate(jwt, User.Constants.ACADEMIC_FRIEND);
        return ResponseEntity.ok(ReportResponseBody.of(reportUseCase.update(requestBody.getId(),
                requestBody.getObservations(), requestBody.getState())));
    }

    @GetMapping
    public ResponseEntity<List<ReportResponseBody>> findAll(@RequestHeader("Authorization") String jwt) {
        log.info("findAll");
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(ReportResponseBody.of(reportUseCase.findAll()));
    }
}
