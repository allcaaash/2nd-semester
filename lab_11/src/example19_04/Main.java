package example19_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var integers = new ArrayList<Integer>();
        Random random = new Random();

        System.out.println("\n" + "Список до:" + "\n");

        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(100));
            System.out.println(integers.get(i));
        }

        var integersAfter = squareList(integers);

        System.out.println("\n" + "Список после:" + "\n");
        for (Integer i : integersAfter) {
            System.out.println(i);
        }
    }

    public static List<Integer> squareList(List<Integer> list) {
        return list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }
}
