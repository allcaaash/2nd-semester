package example19_06;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");

        StringBuilder sb = new StringBuilder();
        boolean isFirstZero = false;
        int count = 1;
        int result = 1;

        for (Map.Entry<Integer, String> iter : map.entrySet()) {
            if (iter.getKey() > 5)
                System.out.println("Key: " + iter.getKey() + ", Value: " + iter.getValue());
            else if (iter.getKey() == 0)
                isFirstZero = true;

            if (isFirstZero) {
                sb.append(iter.getValue());
                if (count == map.size())
                    sb.append(".");
                else
                    sb.append(", ");
            }

            if (iter.getValue().length() > 5)
                result *= iter.getKey();

            count++;
        }

        System.out.println("Key = 0: " + sb.toString());
        System.out.println("Result = " + result);
    }
}
