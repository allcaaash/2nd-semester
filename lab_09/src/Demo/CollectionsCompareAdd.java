package Demo;

import java.util.*;

public class CollectionsCompareAdd {
    public static void main(String[] args) {
        SortedMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();

        System.out.println("Время добавления в конец: " + addLast(sortedMap));
        System.out.println("Время добавления в начало: " + addFirst(sortedMap));
    }

    public static int addFirst(SortedMap<Integer, Integer> sortedMap) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 19000000; i++) {
            SortedMap<Integer, Integer> temp = new TreeMap<Integer, Integer>();
            temp.put(i, i);
            temp.putAll(sortedMap);
            sortedMap = temp;
        }
        long end = System.currentTimeMillis();

        return (int)(end - start);
    }

    public static int addLast(SortedMap<Integer, Integer> sortedMap) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 19000000; i++) {
            sortedMap.put(i, i);
        }
        long end = System.currentTimeMillis();

        return (int)(end - start);
    }
}
