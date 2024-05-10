package example19_01;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array) + "\n");

        int[] result = filterEvenNum(array);
        System.out.println("Итоговый массив:");
        System.out.println(Arrays.toString(result));
    }

    public static int[] filterEvenNum(int[] array) {
        return Arrays.stream(array)
                .filter(x -> x % 2 == 0)
                .toArray();
    }
}
