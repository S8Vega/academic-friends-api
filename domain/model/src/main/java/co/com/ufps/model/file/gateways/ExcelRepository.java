package co.com.ufps.model.file.gateways;

import java.util.List;
import java.util.Map;

public interface ExcelRepository {
    List<Map<String, Object>> read(Object file);

    Object write(List<Map<String, Object>> data);
}
