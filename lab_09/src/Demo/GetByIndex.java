package Demo;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.SortedSet;
import java.util.SortedMap;
import java.util.TreeSet;
import java.util.TreeMap;

public class GetByIndex {
    public static void main(String[] args) {
        SortedMap<Long, Long> sortedMap = new TreeMap<Long, Long>();
        long n = 19000000L;

        for (long i = 0; i < n; i++) {
            sortedMap.put(i, i);
        }

        Random random = new Random();
        long randomIndex = random.nextLong(n);

        long start = System.currentTimeMillis();
        long index = sortedMap.get(randomIndex);
        long end = System.currentTimeMillis();

        System.out.println("Время получения значения по ключу: " + (end - start));
        System.out.println("Индекс равен " + index);
    }
}
