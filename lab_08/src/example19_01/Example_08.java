package example19_01;

import java.io.*;
import java.net.URL;

public class Example_08 {
    public static void readAllByByte(Reader in) throws IOException {
        while (true) {
            int oneByte = in.read();        // Читает 1 байт
            if (oneByte != -1) {            // Признак конца файла
                System.out.println((char) oneByte);
            } else {
                System.out.println("\n" + "the end");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            // С потоком связан файл
            InputStream inFile = new FileInputStream("E:\\MyFile1.txt");        // Байтовый поток
            Reader rFile = new InputStreamReader(inFile, "cp1251");       // Символьный поток

            readAllByByte(rFile);
            System.out.println("\n\n\n");
            inFile.close();
            rFile.close();

            // С потоком связана интернет-страница
            InputStream inURL = new URL("http://google.com").openStream();      // Байтовый поток
            Reader rURL = new InputStreamReader(inURL, "cp1251");         // Символьный поток

            readAllByByte(rURL);
            System.out.println("\n\n\n");
            inURL.close();
            rURL.close();

            // С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream(new byte[] {5, 8, 3, 9, 11});
            Reader rArray = new InputStreamReader(inArray, "cp1251");     // Символьный поток

            readAllByByte(rArray);
            System.out.println("\n\n\n");
            inArray.close();
            rArray.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
