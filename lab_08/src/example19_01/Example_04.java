package example19_01;

import java.io.*;
import java.util.Scanner;

public class Example_04 {
    public static void main(String[] args) {
        try {
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

            File f2 = new File("E:\\My\\numRez.txt");
            f2.createNewFile();

            DataInputStream rd = new DataInputStream(new FileInputStream(f1.getAbsoluteFile()));
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsoluteFile()));

            try {
                while(true) {
                    float number = rd.readFloat();
                    wr.writeFloat(number);
                    System.out.println("Number: " + number);
                }
            } catch(EOFException ex) {}

            wr.flush();
            wr.close();
            rd.close();
        } catch (IOException ex) {
            System.out.println("End of the file");
        }
    }
}
