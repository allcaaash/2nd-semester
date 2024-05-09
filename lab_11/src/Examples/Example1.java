package Examples;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = in.nextInt();

        int[] array = new int[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }

        System.out.println("Массив array: ");
        System.out.println(Arrays.toString(array));

        int[] arrayResult = filterEvenNumbers(array);

        System.out.println("Массив arrayResult: ");
        System.out.println(Arrays.toString(arrayResult));
    }

    public static int[] filterEvenNumbers(int[] array) {
        return Arrays.stream(array).filter(x -> x % 2 == 0).toArray();
    }
}
