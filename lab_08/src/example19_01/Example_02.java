package example19_01;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

//Прочитать и вывести на экран информацию из трех источников:
//файла на диске, интернет-страницы и массива типа byte.

public class Example_02 {
    public static void readAllByByte(InputStream in) throws IOException {
        while (true) {
            int oneByte = in.read();
            if (oneByte != -1) {
                System.out.print((char) oneByte);
            } else {
                System.out.print("\n" + "end");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            // A file with a stream
            InputStream inFile = new FileInputStream("C:/tmp/text.txt");
            readAllByByte(inFile);
            System.out.print("\n\n\n");
            inFile.close();

            // URL with a stream
            InputStream inURL = new URL("http://google.com").openStream();
            readAllByByte(inURL);
            System.out.print("\n\n\n");
            inURL.close();

            // A byte type array with a stream
            InputStream inArray = new ByteArrayInputStream(new byte[] {7, 9, 3, 7, 4});
            readAllByByte(inArray);
            System.out.print("\n\n\n");
            inArray.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
