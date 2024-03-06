package example19_01;

import java.io.*;
import java.util.Scanner;

public class Example_04 {
    public static void main(String[] args) {
        try {
            // Содание исходного файла numIsh.txt и запись в него чисел типа float
            File f1 = new File("E:\\My\\numIsh.txt");
            f1.createNewFile();

            Scanner sc = new Scanner(System.in, "cp1251");

            DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));
            System.out.println("Enter a numbers:");
            int count = sc.nextInt();
            for (int i = 0; i < count; i++)
                wr.writeFloat(sc.nextInt());

            wr.flush();
            wr.close();

            // Создание файла numRez.txt и переписывание в него чисел из numIsh.txt
            File f2 = new File("E:\\My\\numRez.txt");
            f2.createNewFile();

            // Поток для чтения из исходого файла numIsh.txt
            DataInputStream rd = new DataInputStream(new FileInputStream(f1.getAbsoluteFile()));
            // Поток для записи в результирующий файл numRez.txt
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsoluteFile()));

            try {
                while(true) {
                    float number = rd.readFloat();              // Чтение-запись из одного
                    wr.writeFloat(number);                      // файла в другой
                    System.out.println("Number: " + number);
                }
            } catch(EOFException ex) {
                /*NOP*/
            }

            wr.flush();
            wr.close();
            rd.close();
        } catch (IOException ex) {
            System.out.println("End of the file");
        }
    }
}
