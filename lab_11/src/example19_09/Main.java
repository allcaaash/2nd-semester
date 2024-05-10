package example19_09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String inputString = "Это пример строки 123 без цифр, но с некоторыми специальными символами !@#$%";
        var list = List.of(inputString.split(" "));
        System.out.println(list);
        var resultLst = getListWithStrings(list);
        System.out.println(resultLst);
    }

    public static List<String> getListWithStrings(List<String> list) {
        return list.stream()
                .filter(s -> s.chars().allMatch(Character::isLetter))
                .collect(Collectors.toList());
    }
}
