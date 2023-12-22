package co.com.ufps.usecase.file;

import co.com.ufps.model.file.gateways.FileRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class FileUseCase {
    private final FileRepository fileRepository;

    public List<Map<String, Object>> read(Object file) {
        return fileRepository.read(file);
    }
}
