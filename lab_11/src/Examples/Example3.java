package Examples;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {
    public static void main(String[] args) {
        String string = "Напишите функцию, Которая принимает на вход список " +
                        "строк и возвращает новый список, Содержащий только " +
                        "те строки, Которые начинаются с большой буквы.";

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
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}
