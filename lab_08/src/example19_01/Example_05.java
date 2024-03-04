package example19_01;

import java.io.*;
import java.util.Scanner;

public class Example_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a name of the file => ");
        String fileName = sc.nextLine();
        try {
            File f1 = new File(fileName);
            f1.createNewFile();
            System.out.println("Absolute path of the file: " + f1.getAbsolutePath());
            System.out.println("Enter the numbers of the lines for writing to the file:");
            int n = sc.nextInt();

            // Create stream for writing
            DataOutputStream dOut = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the line for writing to the file => ");
                String str = sc.nextLine();

                dOut.writeUTF(str + "\n");
            }
            dOut.flush();
            dOut.close();

            // Reading and output from file
            DataInputStream dIn = new DataInputStream(new FileInputStream(f1));
            while (dIn.available() > 0) {
                System.out.println(dIn.readUTF());
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }
}
