package example19_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                Scanner in = new Scanner(System.in);

                System.out.println("Введите размер массива:");
                int size = in.nextInt();

                int[] array = new int[size];

                for (int i = 0; i < size; i++) {
                    int userValue = in.nextInt();
                    if (userValue < 0) {
                        throw new NegativeValueException();
                    }
                    array[i] = userValue;
                }

                int result = 0;
                for (int i = 0; i < size; i++) {
                    result += array[i];
                }

                result = result / size;
                System.out.println("Среднее значение из всех элементов массива = " + result);
            } catch (InputMismatchException e) {
                System.out.println("Введена строка вместо числа");
            } catch (NegativeArraySizeException e) {
                System.out.println("Попытка присвоить массиву отрицательный размер");
            } catch (NegativeValueException e) {
                System.out.println("Попытка разместить отрицательное значение в массив");
            } catch (ArithmeticException e) {
                System.out.println("Попытка деления на ноль");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Попытка выхода за пределы массива");
            }
        }
    }
}
