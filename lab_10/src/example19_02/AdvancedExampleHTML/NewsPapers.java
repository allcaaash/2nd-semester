package example19_02.AdvancedExampleHTML;

import example19_02.AdvancedExampleJSON.JSON_Parser;
import jdk.jshell.spi.ExecutionControl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsPapers {
    public static void main(String[] args) {
        int attemptCount = 3;
        while (attemptCount != 0) {
            try {
                // Получаем HTML-код страницы
                Document doc = Jsoup.connect("https://www.spotify.com/int/why-not-available/").get();
                //Document doc = Jsoup.connect("http://fat.urfu.ru/index.html").get();

                // Извлекаем список новостей
                Elements newsParent = doc.select("body > table > tbody > tr > td > div > table > " +
                        "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > " +
                        "tr > td:nth-child(1)");

                attemptCount = 0;

                try {
                    // Записываем последние 10 новостей в файл
                    FileWriter fileWriter = new FileWriter(PathToFile.newsPaperPath);
                    for (int i = 3; i < 20; i++) {
                        if(!(i % 2 == 0)) {
                            List<Node> nodes = newsParent.get(0).childNodes();

                            fileWriter.write("Тема: " + ((Element) nodes.get(i)).getElementsByClass("blocktitle").get(0).childNodes().get(0) + "\n");
                            fileWriter.write("Дата: " + ((Element) nodes.get(i)).getElementsByClass("blockdate").get(0).childNodes().get(0) + "\n");
                            fileWriter.write("\n");
                        }
                    }
                    fileWriter.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            } catch (IOException ex) {
                //ex.printStackTrace();
                System.out.println("Не удалось подключиться к веб-странице.");
                System.out.println("Оставшихся попыток: " + attemptCount);
                for (int i = 10; i >= 0; i--) {
                    System.out.println("Повторное подключение через: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                attemptCount--;
            }
        }
    }
}
