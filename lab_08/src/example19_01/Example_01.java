package example19_01;

import java.io.File;

//Создание файлов и папок.
public class Example_01 {
    public static void main(String[] args) {
        try {
            // Creating the first file
            File f1 = new File("MyFile1.txt");
            f1.createNewFile();
            if (f1.exists()) {
                System.out.println("Created!!!");
                System.out.println("Absolute_path_1 is: " + f1.getAbsolutePath());
            }

            // Creating the second file
            File f2 = new File("E:\\MyFile2.txt");
            f2.createNewFile();
            System.out.println("Absolute_path_2 is: " + f2.getAbsolutePath());

            // Creating nested folders
            File f3 = new File("E:\\Folder1\\Folder2\\Folder3");
            f3.mkdirs();
            System.out.println("Absolute_path_3 is: " + f3.getAbsolutePath());
        } catch (Exception ex) {
            System.out.println("Error :" + ex);
        }
    }
}
