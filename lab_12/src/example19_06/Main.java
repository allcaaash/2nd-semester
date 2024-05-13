package example19_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static final int threadNum = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[18];
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(100);

        System.out.println(Arrays.toString(array));

        try {
            System.out.println("Сумма всех элементов массива: " + arrayElementsSum(array));
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static int arrayElementsSum(int[] array) throws InterruptedException{
        int chunkSize = array.length / threadNum; // Размер одного чанка массива
        int[][] splitArrays = new int[threadNum][];
        for (int i = 0; i < threadNum; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, array.length);

            splitArrays[i] = Arrays.copyOfRange(array, start, end);
        }

        var arraysSum = new ArrayList<Integer>();
        var threads = new ArrayList<Thread>();

        for (int i = 0; i < threadNum; i++) {
            final int index = i;
            Thread thread = new Thread(() -> {
                int sum = 0;
                for (int j = 0; j < splitArrays[index].length; j++) {
                    sum += splitArrays[index][j];
                }
                synchronized (arraysSum) {
                    arraysSum.add(sum);
                }
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads)
            thread.join();

        return arraysSum.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
