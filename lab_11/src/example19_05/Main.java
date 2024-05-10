package example19_05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String string = "Напишите функцию, которая принимает на вход список строк " +
                        "и возвращает новый список, содержащий только те строки, " +
                        "которые содержат заданную подстроку.";

        var list = List.of(string.split(" "));
        var listResult = findSubString(list);
        for (String line : listResult) {
            System.out.println(line);
        }
    }

    public static List<String> findSubString (List<String> list) {
        return list.stream()
                .filter(s -> (s.indexOf("строк") != -1))
                .collect(Collectors.toList());
    }
}
