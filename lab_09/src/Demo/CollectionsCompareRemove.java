package Demo;

import java.util.*;

public class CollectionsCompareRemove {
    public static void main(String[] args) {
        SortedMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < 19000000; i++) {
            sortedMap.put(i, i);
        }
        System.out.println("Время удаления из начала: " + removeFirst(sortedMap));
        for (int i = 0; i < 19000000; i++) {
            sortedMap.put(i, i);
        }
        System.out.println("Время удаления из конца: " + removeLast(sortedMap));
        for (int i = 0; i < 19000000; i++) {
            sortedMap.put(i, i);
        }
        System.out.println("Время удаления из середины: " + removeMiddle(sortedMap));
    }

    public static int removeFirst(SortedMap<Integer, Integer> sortedMap) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 19000000; i++) {
            sortedMap.remove(i);
        }
        long end = System.currentTimeMillis();

        return (int)(end - start);
    }

    public static int removeMiddle(SortedMap<Integer, Integer> sortedMap) {
        long start = System.currentTimeMillis();
        while (!sortedMap.isEmpty()) {
            List<Integer> list = new ArrayList<>(sortedMap.keySet());
            sortedMap.remove(list.get(list.size() / 2));
        }
        long end = System.currentTimeMillis();

        return (int)(end - start);
    }

    public static int removeLast(SortedMap<Integer, Integer> sortedMap) {
        long start = System.currentTimeMillis();
        for (int i = 19000000; i > 0; i--) {
            sortedMap.remove(i);
        }
        long end = System.currentTimeMillis();

        return (int)(end - start);
    }
}
