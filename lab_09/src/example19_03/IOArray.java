package example19_03;

import java.util.Scanner;

public class IOArray {
    private static final Scanner in = new Scanner(System.in);

    public static void inputArray(int[] array, int it) {
        if (it == array.length)
            return;
        else {
            array[it] = in.nextInt();
            inputArray(array, ++it);
        }
    }

    public static void outputArray(int[] array, int it) {
        if (it == array.length)
            return;
        else {
            System.out.println(array[it]);
            outputArray(array, ++it);
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите размер массива: ");
        int[] array = new int[in.nextInt()];
        System.out.println("Заполните массив значениями: ");
        inputArray(array, 0);
        System.out.println("Вывод значений массива: ");
        outputArray(array, 0);

        in.close();
    }
}
