package example19_03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите размер массива:");
            byte size = in.nextByte();
            System.out.println();

            byte[] array = new byte[size];

            System.out.println("Заполнение массива");
            for (byte i = 0; i < size; i++) {
                array[i] = in.nextByte();
            }

            try {
                int result = 0;
                for (byte i = 0; i < size; i++) {
                    result += array[i];
                    if (result > Byte.MAX_VALUE || result < Byte.MIN_VALUE)
                        throw new ArithmeticException();
                }
                System.out.println("Сумма всех элементов массива = " + result);
            } catch (ArithmeticException e) {
                System.out.println("Сумма всех элементов массива выходит за границы диапазодна типа byte");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка входного значения");
        } catch (NegativeArraySizeException e) {
            System.out.println("Попытка присвоить массиву отрицательный размер");
        }
    }
}
