package example19_10;

import java.util.ArrayList;
import java.util.Arrays;
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

        var result = getNumbers(list);
        System.out.println(result);
    }

    public static List<Integer> getNumbers(List<Integer> list) {
        return list.stream()
                .filter(x -> x < 50)
                .collect(Collectors.toList());
    }
}
