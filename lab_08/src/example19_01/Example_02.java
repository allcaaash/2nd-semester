package example19_01;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

//Прочитать и вывести на экран информацию из трех источников:
//файла на диске, интернет-страницы и массива типа byte.

public class Example_02 {
    // Метод для чтения данных из потока по байтам с выводом
    public static void readAllByByte(InputStream in) throws IOException {
        while (true) {
            int oneByte = in.read(); // Читает 1 байт
            if (oneByte != -1) {    // Признак отсутствия конца файла
                System.out.print((char) oneByte);
            } else {
                System.out.print("\n" + "end");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            // С потоком связан файл
            InputStream inFile = new FileInputStream("C:/tmp/text.txt");
            readAllByByte(inFile);
            System.out.print("\n\n\n");
            inFile.close();

            // С потоком связана веб-страница
            InputStream inURL = new URL("http://google.com").openStream();
            readAllByByte(inURL);
            System.out.print("\n\n\n");
            inURL.close();

            // С потоком всязан массив типа byte
            InputStream inArray = new ByteArrayInputStream(new byte[] {7, 9, 3, 7, 4});
            readAllByByte(inArray);
            System.out.print("\n\n\n");
            inArray.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
