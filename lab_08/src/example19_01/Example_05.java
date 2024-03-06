package example19_01;

import java.io.*;
import java.util.Scanner;

public class Example_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a name of the file => ");
        String fileName = sc.nextLine();
        try {
            // Создается файл
            File f1 = new File(fileName);
            f1.createNewFile(); // Файл создан
            System.out.println("Absolute path of the file: " + f1.getAbsolutePath());
            System.out.println("Enter the numbers of the lines for writing to the file:");
            int n = sc.nextInt();

            // Создается поток для записи с учетом типа данных - DataOutputStream,
            // и ему в качестве параметра передается поток FileOutputStream
            DataOutputStream dOut = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));
            sc.nextLine();      // Очистка буфера
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the line for writing to the file => ");
                String str = sc.nextLine();

                dOut.writeUTF(str + "\n");
            }
            dOut.flush();       // Дописываем несохраненные данные на диск
            dOut.close();       // Закрываем поток

            // Чтение и вывод данных из созданного файла
            DataInputStream dIn = new DataInputStream(new FileInputStream(f1));
            while (dIn.available() > 0) {
                System.out.println(dIn.readUTF());
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }
}
