package co.com.ufps.filereader;

import co.com.ufps.model.file.gateways.ExcelRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Log4j2
@Repository
public class ExcelAdapter implements ExcelRepository {

    private static CellStyle buildHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();

        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        style.setAlignment(HorizontalAlignment.CENTER);
        font.setBold(true);
        style.setFont(font);

        return style;
    }

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

    @Override
    public Object write(List<Map<String, Object>> data) {
        log.info("Escribiendo archivo");
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("data");

            Row headerRow = sheet.createRow(0);
            CellStyle style = buildHeaderStyle(workbook);
            int cellIndex = 0;
            for (String header : data.get(0).keySet()) {
                Cell cell = headerRow.createCell(cellIndex++);
                cell.setCellValue(header);
                cell.setCellStyle(style);
            }

            int rowIndex = 1;
            for (Map<String, Object> fila : data) {
                Row row = sheet.createRow(rowIndex++);
                int columnIndex = 0;
                for (Object valor : fila.values()) {
                    Cell cell = row.createCell(columnIndex++);
                    if (valor instanceof String) {
                        cell.setCellValue((String) valor);
                    } else if (valor instanceof Number) {
                        cell.setCellValue(((Number) valor).doubleValue());
                    }
                }
            }

            for (int i = 0; i < data.get(0).size(); i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            workbook.write(bos);
            InputStream inputStream = new ByteArrayInputStream(bos.toByteArray());
            return new InputStreamResource(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir el archivo", e);
        }
    }
}
