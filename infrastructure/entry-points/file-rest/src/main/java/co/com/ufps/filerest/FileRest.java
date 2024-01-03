package co.com.ufps.filerest;

import co.com.ufps.usecase.file.FileUseCase;
import co.com.ufps.usecase.security.SecurityUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/file", produces = MediaType.APPLICATION_JSON_VALUE)
public class FileRest {
    private final FileUseCase fileUseCase;
    private final SecurityUseCase securityUseCase;

    @GetMapping(value = "/{directory}/{name}")
    public ResponseEntity<Resource> findByName(@RequestHeader("Authorization") String jwt,
                                               @PathVariable String directory,
                                               @PathVariable String name) {
        String fileName = String.format("%s/%s", directory, name);
        log.info("findByName: " + fileName);
        securityUseCase.validate(jwt);
        InputStream inputStream = fileUseCase.findByName(fileName);

        InputStreamResource resource = new InputStreamResource(inputStream);
        return ResponseEntity.ok(resource);
    }

    @PostMapping("/convert")
    public ResponseEntity<Object> convert(@RequestHeader("Authorization") String jwt,
                                          @RequestBody List<Map<String, Object>> data) {
        log.info("convert");
        securityUseCase.validate(jwt);
        return ResponseEntity.ok(fileUseCase.write(data));
    }
}
