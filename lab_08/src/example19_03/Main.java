package example19_03;

//Создать проект, позволяющий из одного текстового файла,
//содержащего несколько строк (тип String) заранее подготовленного текста
//на русском языке (Пушкин, Лермонтов или другой российсмки классик на
//Ваш вкус), построчно переписать в другой текстовый файл слова
//начинающиеся с согласных букв..
//Требования:
//– слова из предложения выделять методом split();
//– в новом файле следует указать номер строки, в которой искомые
//слова находились в исходном файле;
//– для каждой строки указать количество выбранных слов.

import java.io.*;

public class Main {
    public static boolean startsWithConsonant (String str) {
        if (str.isEmpty())
            return false;
        char firstSymbol = str.toLowerCase().charAt(0);

        return !("ауоиэыяюеё".contains(String.valueOf(firstSymbol)));
    }

    public static void main(String[] args) {
        String readFile = "borodino.txt";
        String writeFile = "result.txt";

        File readPath = new File(System.getProperty("user.dir") + File.separator + "stuffs", readFile);
        File writePath = new File(System.getProperty("user.dir") + File.separator + "stuffs", writeFile);

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(readPath));
            writer = new BufferedWriter(new FileWriter(writePath));

            int lineCount = 0;
            String line = "";

            while ((line = reader.readLine()) != null) {
                lineCount++;
                int wordsCount = 0;
                String[] lines = line.replaceAll("[^а-яА-Я]", " ").split(" ");
                for (String str : lines) {
                    if (startsWithConsonant(str)) {
                        wordsCount++;
                        writer.write(str);
                        writer.write(" ");
                    }
                }
                if (wordsCount > 0) {
                    writer.write("\nСтрока: " + lineCount + ", Слов: " + wordsCount + "\n");
                    writer.newLine();
                }
            }
            writer.flush();
            writer.close();
            reader.close();

        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
