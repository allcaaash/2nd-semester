package example19_08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        var list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(20));
        }
        System.out.println(list);
        System.out.println("\n");

        var resultList = getNumbers(list);
        System.out.println(resultList);
    }

    public static List<Integer> getNumbers(List<Integer> list) {
        return list.stream()
                .filter(x -> x > 7)
                .collect(Collectors.toList());
    }
}
