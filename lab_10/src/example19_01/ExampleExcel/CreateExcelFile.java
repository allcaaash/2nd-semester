package example19_01.ExampleExcel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;

public class CreateExcelFile {
    public static void main(String[] args) throws IOException {
        // Создаем новую книгу Excel
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Создаем новый лист в книге
        XSSFSheet sheet = workbook.createSheet("Товары");

        // Записываем данные в ячейки
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Товар");
        headerRow.createCell(1).setCellValue("Характеристики");
        headerRow.createCell(2).setCellValue("Стоимость");

        Row dataRow1 = sheet.createRow(1);
        dataRow1.createCell(0).setCellValue("Книга");
        dataRow1.createCell(1).setCellValue("Жанр: Фантастика, Автор: Иванов И.И.");
        dataRow1.createCell(2).setCellValue(500.00);

        Row dataRow2 = sheet.createRow(2);
        dataRow2.createCell(0).setCellValue("Компьтер");
        dataRow2.createCell(1).setCellValue("Процессор: Intel Core i5, Оперативная память: 16 Gb");
        dataRow2.createCell(2).setCellValue(2500.00);

        //Записываем книгу Excel в файл
        String filePath = "lab_10\\src\\example19_01\\ExampleExcel\\example.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("Данные записаны в файл: " + filePath);
    }
}
