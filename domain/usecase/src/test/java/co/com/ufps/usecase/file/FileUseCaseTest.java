package co.com.ufps.usecase.file;

import co.com.ufps.model.file.gateways.ExcelRepository;
import co.com.ufps.model.file.gateways.FileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FileUseCaseTest {
    @InjectMocks
    private FileUseCase fileUseCase;
    @Mock
    private ExcelRepository excelRepository;
    @Mock
    private FileRepository fileRepository;

    @Test
    void read() {
        Object file = new Object();

        List<Map<String, Object>> objects = fileUseCase.read(file);

        verify(excelRepository).read(file);
    }

    @Test
    void save() throws IOException {
        String name = "name";
        File file = mock(File.class);

        fileUseCase.save(name, file);

        verify(fileRepository).save(name, file);
    }

    @Test
    void findByName() {
        String name = "name";

        fileUseCase.findByName(name);

        verify(fileRepository).findByName(name);
    }

    @Test
    void write() {
        List<Map<String, Object>> data = mock(List.class);

        fileUseCase.write(data);

        verify(excelRepository).write(data);
    }
}