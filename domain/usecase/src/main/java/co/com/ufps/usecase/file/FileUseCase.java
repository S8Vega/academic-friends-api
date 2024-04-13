package co.com.ufps.usecase.file;

import co.com.ufps.model.file.gateways.ExcelRepository;
import co.com.ufps.model.file.gateways.FileRepository;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class FileUseCase {
    private final ExcelRepository excelRepository;
    private final FileRepository fileRepository;

    public List<Map<String, Object>> read(Object file) {
        return excelRepository.read(file);
    }

    public void save(String name, File file) throws IOException {
        fileRepository.save(name, file);
    }

    public InputStream findByName(String name) {
        return fileRepository.findByName(name);
    }

    public Object write(List<Map<String, Object>> data) {
        return excelRepository.write(data);
    }
}
