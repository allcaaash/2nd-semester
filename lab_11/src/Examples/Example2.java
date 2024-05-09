package Examples;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = in.nextInt();

        int[] array1 = new int[size];
        int[] array2 = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array1[i] = random.nextInt(200);
            array2[i] = random.nextInt(200);
        }

        System.out.println("Массив array1: ");
        System.out.println(Arrays.toString(array1));
        System.out.println("Массив arrays2: ");
        System.out.println(Arrays.toString(array2));

        int[] arrayResult = findCommonElements(array1, array2);
        System.out.println("Массив arrayResult: ");
        System.out.println(Arrays.toString(arrayResult));
    }

    public static int[] findCommonElements(int[] array1, int[] array2) {
        return Arrays.stream(array1)
                .filter(x -> Arrays.stream(array2)
                .anyMatch(y -> y == x))
                .toArray();
    }
}
