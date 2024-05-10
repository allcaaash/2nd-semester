package example19_03;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String string = "Съешь же ещё этих Мягких французских Булок, да Выпей Чаю";

        List<String> list = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования: " + "\n");
        for (String word : list) {
            System.out.println(word);
        }

        List<String> resultList = filterCapitalizedStrings(list);

        System.out.println("\n" + "Слова, начинающиеся с заглавной буквы: " + "\n");
        for (String word : resultList) {
            System.out.println(word);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(x -> Character.isUpperCase(x.charAt(0)))
                .collect(Collectors.toList());
    }
}