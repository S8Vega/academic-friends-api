package co.com.ufps.reportrest;

import co.com.ufps.model.report.Report;
import co.com.ufps.usecase.report.ReportUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportRest {
    public static final int SIZE_BUFFER = 10000;
    private final ReportUseCase reportUseCase;

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
    public ResponseEntity<Report> save(@RequestPart String academicFriend, @RequestPart String type,
                                       @RequestPart String date, @RequestPart MultipartFile file)
            throws IOException {
        log.info("save: {}", academicFriend);
        return ResponseEntity.ok(reportUseCase.save(academicFriend, type, date, convert(file)));
    }
}
