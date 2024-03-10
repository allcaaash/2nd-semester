package example19_02;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.*;
import java.util.Scanner;

//Задание 2. Создать проект, позволяющий из одного, предварительно
//созданного программными средствами файла, переписать данные,
//соответствующие условию - в исходном файле содержится две строки в
//формате UTF-8 и 5 чисел типа double. В результирующий файл переписать
//вторую строку и положительные числа.
public class Main {
    public static void main(String[] args) throws IOException {
        final int stringCount = 2;      // Кол-во строк String
        final int doubleCount = 5;      // Кол-во строк double

        Scanner scanner = new Scanner(System.in);
        DataOutputStream wr = null;
        DataInputStream rd = null;

        try {
            // Создание и заполнение файла для дальнейшего чтения
            File readFile = new File("example19_02_read.txt");
            readFile.delete();
            if (readFile.createNewFile()) {
                wr = new DataOutputStream(new FileOutputStream(readFile.getAbsolutePath()));

                System.out.println("Enter the lines to write to the file: ");
                for (int i = 0; i < stringCount; i++)
                    wr.writeUTF(scanner.nextLine());

                System.out.println("Enter double values to write to the file: ");
                for (int i = 0; i < doubleCount; i++)
                    wr.writeUTF(scanner.nextLine());

                wr.flush();
                wr.close();
            } else
                System.out.println("Can't create the file: " + readFile.getName());

            // Переписываем нужные значения из первого файла во второй
            File writeFile = new File("example19_02_write.txt");
            writeFile.delete();
            if (writeFile.createNewFile()) {
                rd = new DataInputStream(new FileInputStream(readFile.getAbsolutePath()));
                wr = new DataOutputStream(new FileOutputStream(writeFile.getAbsolutePath()));

                try {
                    String line;
                    int lineCount = 0;
                    while ((line = rd.readUTF()) != null) {
                        lineCount++;

                        if (lineCount == stringCount) {
                            wr.writeUTF(line + "\n");
                            continue;
                        } else if (lineCount > stringCount) {
                            try {
                                double value = Double.parseDouble(line);
                                if (value > 0)
                                    wr.writeUTF(line + "\n");
                            } catch (NumberFormatException ex) {
                                /*NOP*/
                            }
                        } else
                            continue;
                    }
                } catch (IOException ex) {
                    System.out.println("End of the file");
                }
            } else
                System.out.println("Can't create the file: " + writeFile.getName());
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        } finally {
            rd.close();
            wr.close();
        }
    }
}
