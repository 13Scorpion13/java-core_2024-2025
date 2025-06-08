package lr8;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.*;

public class Example911 {
    private static void printBooks(NodeList bookList) {
        System.out.println("\nСписок книг:");
        for (int i = 0; i < bookList.getLength(); i++) {
            Node node = bookList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Название: " + element.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Автор: " + element.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("Год издания: " + element.getElementsByTagName("year").item(0).getTextContent());
                System.out.println();
            }
        }
    }

    // Добавление новой книги
    private static void addNewBook(Document doc, Scanner in) throws Exception {
        System.out.print("Введите название книги: ");
        String title = in.nextLine();
        System.out.print("Введите автора: ");
        String author = in.nextLine();
        System.out.print("Введите год издания: ");
        String year = in.nextLine();

        Element root = doc.getDocumentElement();
        Element newBook = doc.createElement("book");
        root.appendChild(newBook);

        addChild(doc, newBook, "title", title);
        addChild(doc, newBook, "author", author);
        addChild(doc, newBook, "year", year);

        saveChanges(doc);
        System.out.println("Книга успешно добавлена!");
    }

    // Утилитный метод для добавления дочерних элементов
    private static void addChild(Document doc, Element parent, String tagName, String text) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(text));
        parent.appendChild(element);
    }

    // Поиск книг по автору или году издания
    private static void searchBooks(Document doc, Scanner in) {
        System.out.println("Выберите критерий поиска:");
        System.out.println("1 — По автору");
        System.out.println("2 — По году издания");
        System.out.print("Введите номер: ");
        String choice = in.nextLine();

        String tagToSearch = choice.equals("1") ? "author" : "year";
        System.out.print("Введите значение для поиска: ");
        String value = in.nextLine();

        NodeList bookList = doc.getElementsByTagName("book");
        List<Element> results = new ArrayList<>();

        for (int i = 0; i < bookList.getLength(); i++) {
            Node node = bookList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String fieldValue = element.getElementsByTagName(tagToSearch).item(0).getTextContent();
                if (fieldValue.equalsIgnoreCase(value)) {
                    results.add(element);
                }
            }
        }

        if (results.isEmpty()) {
            System.out.println("Книги не найдены!");
        } else {
            System.out.println("\nРезультаты поиска:");
            for (Element element : results) {
                System.out.println("Название: " + element.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Автор: " + element.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("Год издания: " + element.getElementsByTagName("year").item(0).getTextContent());
                System.out.println();
            }
        }
    }

    // Удаление книги по названию
    private static void deleteBook(Document doc, Scanner in) throws Exception {
        System.out.print("Введите название книги для удаления: ");
        String titleToDelete = in.nextLine();

        NodeList bookList = doc.getElementsByTagName("book");
        boolean found = false;

        for (int i = 0; i < bookList.getLength(); i++) {
            Node node = bookList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String title = element.getElementsByTagName("title").item(0).getTextContent();

                if (title.equalsIgnoreCase(titleToDelete)) {
                    node.getParentNode().removeChild(node);
                    found = true;
                }
            }
        }

        if (found) {
            saveChanges(doc);
            System.out.println("Книга успешно удалена!");
        } else {
            System.out.println("Книга не найдена!");
        }
    }

    // Сохранение изменений в XML-файле
    private static void saveChanges(Document doc) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/lr8/books.xml"));
        transformer.transform(source, result);
    }

    // Основной метод
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/lr8/books.xml");

            // Если файла нет — создаём новый с пустым корнем
            if (!inputFile.exists()) {
                inputFile.getParentFile().mkdirs();
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.newDocument();

                Element root = doc.createElement("library");
                doc.appendChild(root);

                TransformerFactory tff = TransformerFactory.newInstance();
                Transformer tf = tff.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(inputFile);
                tf.transform(source, result);

                System.out.println("Файл books.xml создан.");
            }

            // Парсим XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Scanner in = new Scanner(System.in);
            NodeList bookList = doc.getElementsByTagName("book");

            printBooks(bookList);

            System.out.print("\nДобавить новую книгу? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                addNewBook(doc, in);
            }

            System.out.print("\nИскать книги? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                searchBooks(doc, in);
            }

            System.out.print("\nУдалить книгу? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                deleteBook(doc, in);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
