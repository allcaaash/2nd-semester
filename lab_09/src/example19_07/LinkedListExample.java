package example19_07;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedListExample {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter N(int, N > 1): ");
        int n = in.nextInt();



        var linkedList = new LinkedList<Integer>();
        // Заполняем
        for (int i = 1; i <= n; i++)
            linkedList.add(i);

        long start = System.currentTimeMillis(); // время начала выполнения программы

        while (linkedList.size() != 1) {
            for (int i = 1; i < linkedList.size(); i+=2)
                linkedList.remove(i);
        }
        System.out.println("linkedList value = " + linkedList.get(0));
        System.out.println("Program runtime = " + (System.currentTimeMillis() - start) + " milliseconds");
    }
}
