package utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {
    public static String getCellData(String filePath, String sheetName, int row, int col) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);
        String data = sheet.getRow(row).getCell(col).getStringCellValue();
        wb.close();
        return data;
    }
}