package co.com.ufps.usecase.file;

import co.com.ufps.model.file.gateways.FileReaderRepository;
import co.com.ufps.model.file.gateways.FileRepository;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class FileUseCase {
    private final FileReaderRepository fileReaderRepository;
    private final FileRepository fileRepository;

    public List<Map<String, Object>> read(Object file) {
        return fileReaderRepository.read(file);
    }

    public void save(String name, File file) {
        fileRepository.save(name, file);
    }

    public InputStream findByName(String name) {
        return fileRepository.findByName(name);
    }
}
