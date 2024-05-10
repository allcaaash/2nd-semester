package example19_02;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        int[] array1 = new int[size];
        int[] array2 = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array1[i] = random.nextInt(100);
            array2[i] = random.nextInt(100);
        }

        System.out.println("Исходные массивы:");
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2) + "\n");

        int[] result = findCommonElements(array1, array2);
        System.out.println("Итоговый массив:");
        System.out.println(Arrays.toString(result));
    }

    public static int[] findCommonElements(int[] array1, int[] array2) {
        return Arrays.stream(array1)
                .filter(x -> Arrays.stream(array2)
                .anyMatch(y -> y == x))
                .toArray();
    }
}
