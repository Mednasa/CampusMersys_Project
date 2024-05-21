package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExcelUtility {

    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int column) {
        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            ArrayList<String> satir = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                satir.add(sheet.getRow(i).getCell(j).toString());
            }

            table.add(satir);
        }

        return table;
    }

    public static void writeToExcel(String path, String testResult) {
        File dosya = new File(path);

        if (!dosya.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Scenarios");

            Row newRow = sheet.createRow(0);
            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(testResult);

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("File Created");
        } else {
            FileInputStream inputStream = null;
            Workbook workbook = null;
            Sheet sheet = null;

            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            int rowTotal = sheet.getPhysicalNumberOfRows();
            Row newRow = sheet.createRow(rowTotal);
            Cell newRowCell = newRow.createCell(0);
            newRowCell.setCellValue(testResult);

            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("File already exist");
        }
    }

}
