package example19_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int matrixSize = 10;
        int[][] matrix = new int[matrixSize][matrixSize];
        int value = 1;

        System.out.println("Матрица имеет вид:");
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = value;
                value++;
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Введите номер столбца для его отображения:");
        try {
            int column = in.nextInt();
            for (int i = 0; i < matrixSize; i++) {
                System.out.println(matrix[i][column - 1]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Введена строка вместо числа");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Попытка выхода за пределы массива");
        }
    }
}
