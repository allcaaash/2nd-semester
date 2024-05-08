package example19_02.AdvancedExampleJSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class JSON_Parser {
    private static final String file = "lab_10\\src\\example19_02\\AdvancedExampleJSON\\example.json";
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(file));
                JSONObject jsonObject = (JSONObject) obj;

                System.out.println("Что сделать с JSON файлом?\n" +
                        "1. Найти фильм по режисеру\n" +
                        "2. Добавить новый фильм\n" +
                        "3. Удалить фильм\n" +
                        "Любое другое чисто - Выход из программы\n");

                int choice = in.nextInt();

                switch (choice) {
                    case 1:
                        findByDirector(jsonObject);
                        break;
                    case 2:
                        addNewMovie(jsonObject);
                        break;
                    case 3:
                        deleteMovie(jsonObject);
                        break;
                    default:
                        return;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void findByDirector(JSONObject jsonObject) {
        System.out.print("Введите имя и фамилию режисера для поиска: ");
        in.nextLine();
        String director = in.nextLine();

        JSONArray jsonArray = (JSONArray) jsonObject.get("movies");
        for (Object object : jsonArray) {
            if (object instanceof JSONObject) {
                JSONObject movie = (JSONObject) object;
                if (director.equals(movie.get("director"))) {
                    System.out.println("Название фильма: " + movie.get("title"));
                    System.out.println("Режисер: " + movie.get("director"));
                    System.out.println("Год выпуска: " + movie.get("year"));
                }
            }
        }
    }

    private static void addNewMovie(JSONObject jsonObject) {
        System.out.print("Введите название фильма: ");
        in.nextLine();
        String movie = in.nextLine();

        System.out.print("Введите имя и фамилию режисера: ");
        String director = in.nextLine();

        System.out.print("Введите год выпуска фильма: ");
        String year = in.nextLine();

        JSONArray movies = (JSONArray) jsonObject.get("movies");
        JSONObject newMovie = new JSONObject();
        newMovie.put("year", year);
        newMovie.put("director", director);
        newMovie.put("title", movie);
        movies.add(newMovie);

        try (FileWriter file = new FileWriter(JSON_Parser.file)) {
            file.write(jsonObject.toJSONString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private static void deleteMovie(JSONObject jsonObject) {
        System.out.print("Введите название фильма, который собиратесь удалить: ");
        in.nextLine();
        String delMovie = in.nextLine();

        JSONArray jsonArray = (JSONArray) jsonObject.get("movies");
        Iterator iterator = jsonArray.iterator();
        while(iterator.hasNext()) {
            JSONObject movie = (JSONObject) iterator.next();
            if (delMovie.equals(movie.get("title")))
                iterator.remove();
        }

        try (FileWriter file = new FileWriter(JSON_Parser.file)) {
            file.write(jsonObject.toJSONString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
