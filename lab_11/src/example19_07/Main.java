package example19_07;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String string = "Напишите функцию, которая принимает на вход список строк " +
                        "и возвращает новый список, содержащий только те строки, " +
                        "которые имеют длину больше заданного значения.";

        var list = List.of(string.split(" "));
        var resultList = getStringsForLength(list);
        System.out.println(resultList.toString());
    }

    public static List<String> getStringsForLength(List<String> list) {
        return list.stream()
                .filter(s -> s.length() > 7)
                .collect(Collectors.toList());
    }
}
