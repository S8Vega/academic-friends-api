package co.com.ufps.model.file.gateways;

import java.util.List;
import java.util.Map;

public interface FileReaderRepository {
    List<Map<String, Object>> read(Object file);
}
