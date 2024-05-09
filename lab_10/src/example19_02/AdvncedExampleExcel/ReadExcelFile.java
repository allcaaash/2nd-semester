package example19_02.AdvncedExampleExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {
    public static void main(String[] args) throws IOException {
        // Открываем файл для чтения
        String filePath = "lab_10\\src\\example19_01\\ExampleExcel\\example.xlsx";

        // Проверка наличия файла
        File file = new File(filePath);
        if(!file.exists()) {
            System.out.println("Файл не найден");
            return;
        }

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {

            // Получаем лист из книги по его имени
            XSSFSheet sheet = workbook.getSheet("Товары");
            if (sheet == null) {
                System.out.println("Лист \"Товары\" не найден в файле");
                return;
            }

            // Перебираем строки и ячейки в листе
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // Выводим значение ячейки на экран
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

            System.out.println("Данные успешно прочитаны из файла");

            // Закрываем файл и освобождаем ресурсы
            workbook.close();
            fileInputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
