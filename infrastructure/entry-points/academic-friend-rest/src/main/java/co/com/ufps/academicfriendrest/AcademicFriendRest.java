package co.com.ufps.academicfriendrest;

import co.com.ufps.model.academicfriend.AcademicFriend;
import co.com.ufps.usecase.academicfriend.AcademicFriendUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
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
@RequestMapping(value = "/academic-friend", produces = MediaType.APPLICATION_JSON_VALUE)
public class AcademicFriendRest {
    public static final int SIZE_BUFFER = 10000;
    private final AcademicFriendUseCase academicFriendUseCase;

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
    public AcademicFriend save(@RequestPart MultipartFile classSchedule, @RequestPart MultipartFile resume,
                               @RequestPart String email, @RequestPart String average) throws IOException {
        AcademicFriend academicFriend = new AcademicFriend();
        academicFriend.setEmail(email);
        academicFriend.setAverage(Double.parseDouble(average));
        return academicFriendUseCase.save(academicFriend, convert(classSchedule), convert(resume));
    }
}
