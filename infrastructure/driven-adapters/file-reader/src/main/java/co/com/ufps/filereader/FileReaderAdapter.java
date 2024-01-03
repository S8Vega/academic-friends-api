package co.com.ufps.filereader;

import co.com.ufps.model.file.gateways.FileReaderRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Log4j2
@Repository
public class FileReaderAdapter implements FileReaderRepository {

    @Override
    public List<Map<String, Object>> read(Object object) {
        log.info("Leyendo archivo");
        List<Map<String, Object>> response = new ArrayList<>();
        try {
            MultipartFile file = (MultipartFile) object;
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            Row headerRow = rowIterator.next();

            Map<Integer, String> columnIndexMap = new HashMap<>();
            for (int colIndex = 0; colIndex < headerRow.getLastCellNum(); colIndex++) {
                Cell headerCell = headerRow.getCell(colIndex);
                columnIndexMap.put(colIndex, headerCell.getStringCellValue());
            }
            Map<String, Object> dataMap;
            while (rowIterator.hasNext()) {
                dataMap = new HashMap<>();
                Row row = rowIterator.next();
                for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
                    Cell cell = row.getCell(colIndex);
                    String columnName = columnIndexMap.get(colIndex);
                    Object cellValue = getCellValue(cell);
                    dataMap.put(columnName, cellValue);
                }
                response.add(dataMap);
            }

            workbook.close();
        } catch (IOException | EncryptedDocumentException ex) {
            throw new RuntimeException("Error al leer el archivo", ex);
        }

        return response;
    }

    private Object getCellValue(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> cell.getNumericCellValue();
            case BOOLEAN -> cell.getBooleanCellValue();
            default -> null;
        };
    }
}
