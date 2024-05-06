package example19_02.AdvancedExampleXML;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

public class XMLParser {
    public static Scanner in = new Scanner(System.in);
    private static final String file = "lab_10\\src\\example19_02\\AdvancedExampleXML\\example.xml";

    public static void main(String[] args) {

        while (true) {
            System.out.println("Что сделать с XML файлом?\n" +
                    "1. Добавить новый фильм\n" +
                    "2. Поиск фильма по режисеру или году выпуска в прокат\n" +
                    "3. Удалить фильм из файла\n" +
                    "Любое другое чисто - Выход из программы\n");

            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    addNewMovie();
                    break;
                case 2:
                    findByDirectorOrYear();
                case 3:
                    deleteElementFromXML();
                    break;
                default:
                    return;
            }
        }
    }

    public static void addNewMovie() {
        System.out.print("Введите название фильма: ");
        in.nextLine();
        String movieName = in.nextLine();
        System.out.print("Введите режисера фильма: ");
        String director = in.nextLine();
        System.out.print("Введите год выхода в прокат фильма: ");
        String year = in.nextLine();

        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            Element newMovie = doc.createElement("movie");

            Element newTitle = doc.createElement("title");
            newTitle.appendChild(doc.createTextNode(movieName));
            newMovie.appendChild(newTitle);

            Element newDirector = doc.createElement("director");
            newDirector.appendChild(doc.createTextNode(director));
            newMovie.appendChild(newDirector);

            Element newYear = doc.createElement("year");
            newYear.appendChild(doc.createTextNode(year));
            newMovie.appendChild(newYear);

            Element root = doc.getDocumentElement();
            root.appendChild(newMovie);

            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("lab_10\\src\\example19_02\\AdvancedExampleXML\\example.xml"));
            transformer.transform(source, result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void findByDirectorOrYear() {
        System.out.print("Введите режисера для поиска: ");
        in.nextLine();
        String searchDirector = in.nextLine();
        System.out.print("Введите год выхода в прокат для поиска: ");
        String searchYear = in.nextLine();

        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("movie");

            List<Element> movies = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    movies.add((Element) node);
                }
            }

            movies.stream()
                    .filter(element -> {
                        String director = element.getElementsByTagName("director").item(0).getTextContent();
                        String year = element.getElementsByTagName("year").item(0).getTextContent();
                        return director.equalsIgnoreCase(searchDirector) || year.equalsIgnoreCase(searchYear);
                    })
                    .forEach(element -> {
                        String title = element.getElementsByTagName("title").item(0).getTextContent();
                        String director = element.getElementsByTagName("director").item(0).getTextContent();
                        String year = element.getElementsByTagName("year").item(0).getTextContent();
                        System.out.println("Название: " + title + ", Режиссер: " + director + ", Год: " + year);
                    });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void deleteElementFromXML() {
        System.out.print("Введите название фильма, который хотите удалить: ");
        in.nextLine();
        String removeMovie = in.nextLine();

        try {
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("movie");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (removeMovie.equals(element.getElementsByTagName("title").item(0).getTextContent())) {
                        Node parentNode = element.getParentNode();
                        parentNode.removeChild(element);

                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(inputFile);
                        transformer.transform(source, result);

                        return;
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
