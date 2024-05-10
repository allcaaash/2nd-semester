package example19_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        var list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }

        System.out.println(list);
        System.out.println(dividingWithoutRemainder(list).toString());
    }

    public static List<Integer> dividingWithoutRemainder(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 5 == 0)
                .collect(Collectors.toList());
    }
}
