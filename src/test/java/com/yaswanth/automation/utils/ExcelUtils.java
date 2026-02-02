package com.yaswanth.automation.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {

    private static final String FILE_PATH =
            System.getProperty("user.dir") +
            "/src/test/resources/testdata/LoginData.xlsx";

    public static Map<String, String> getTestData(String sheetName, String testType) {

        Map<String, String> data = new HashMap<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (formatter.formatCellValue(row.getCell(0))
                        .equalsIgnoreCase(testType)) {

                    for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                        String key = formatter.formatCellValue(headerRow.getCell(j));
                        String value = formatter.formatCellValue(row.getCell(j));
                        data.put(key, value);
                    }
                    break;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel data", e);
        }
        return data;
    }
}
