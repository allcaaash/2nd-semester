package example19_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter N(int, N > 1): ");
        int n = in.nextInt();



        List<Integer> arrayList = new ArrayList<>();
        // Заполняем
        for (int i = 1; i <= n; i++)
            arrayList.add(i);

        long start = System.currentTimeMillis(); // время начала выполнения программы

        while (arrayList.size() != 1) {
            for (int i = 1; i < arrayList.size(); i+=2)
               arrayList.remove(i);
        }
        System.out.println("arrayList value = " + arrayList.get(0));
        System.out.println("Program runtime = " + (System.currentTimeMillis() - start) + " milliseconds");
    }
}
