package example19_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static final int threadNum = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        int[] array = new int[18];
        Random random = new Random();
        for (int i = 0;i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        System.out.println(Arrays.toString(array));
        try{
            System.out.println("Максимальное значение в массиве: " + findMaximumValueInArray(array));
        }catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static int findMaximumValueInArray(int[] array) throws InterruptedException{
        int chunkSize = array.length / threadNum; // Размер одного чанка массива

        int[][] splitArrays = new int[threadNum][];
        for (int i = 0; i < threadNum; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, array.length);

            splitArrays[i] = Arrays.copyOfRange(array, start, end);
        }

        var maxValues = new ArrayList<Integer>();
        var threads = new ArrayList<Thread>();

        for (int i = 0; i < threadNum; i++) {
            final int index = i;
            Thread thread = new Thread(() -> {
                int maxValue = Integer.MIN_VALUE;
                for (int j = 0; j < splitArrays[index].length; j++) {
                    if (splitArrays[index][j] > maxValue)
                        maxValue = splitArrays[index][j];
                }
                synchronized (maxValues) {
                    maxValues.add(maxValue);
                }
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads)
            thread.join();

        if (maxValues.size() < threadNum) {
            System.out.println("Что-то пошло не так");
            return Integer.MIN_VALUE;
        }

        return maxValues.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
