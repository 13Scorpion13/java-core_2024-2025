package lr8;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.*;

public class Example8 {

    private static void printPeople(NodeList peopleList) {
        System.out.println("\nСписок людей:");
        for (int i = 0; i < peopleList.getLength(); i++) {
            Node node = peopleList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Имя: " + element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Дата рождения: " + element.getElementsByTagName("birthday").item(0).getTextContent());
            }
        }
    }

    private static void addNewPerson(Document doc, Scanner in) throws Exception {
        System.out.print("Введите имя человека: ");
        String name = in.nextLine();
        System.out.print("Введите дату рождения (например, 1990-05-20): ");
        String birthday = in.nextLine();

        Element root = doc.getDocumentElement();
        Element newPerson = doc.createElement("person");
        root.appendChild(newPerson);

        addChild(doc, newPerson, "name", name);
        addChild(doc, newPerson, "birthday", birthday);

        saveChanges(doc);
        System.out.println("Человек успешно добавлен!");
    }

    private static void addChild(Document doc, Element parent, String tagName, String text) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(text));
        parent.appendChild(element);
    }

    private static void searchPeople(Document doc, Scanner in) {
        System.out.println("Поиск по имени:");

        System.out.print("Введите имя для поиска: ");
        String value = in.nextLine();

        NodeList peopleList = doc.getElementsByTagName("person");
        List<Element> results = new ArrayList<>();

        for (int i = 0; i < peopleList.getLength(); i++) {
            Node node = peopleList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String fieldValue = element.getElementsByTagName("name").item(0).getTextContent();
                if (fieldValue.equalsIgnoreCase(value)) {
                    results.add(element);
                }
            }
        }

        if (results.isEmpty()) {
            System.out.println("Люди не найдены!");
        } else {
            System.out.println("\nРезультаты поиска:");
            for (Element element : results) {
                System.out.println("Имя: " + element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Дата рождения: " + element.getElementsByTagName("birthday").item(0).getTextContent());
            }
        }
    }

    private static void deletePerson(Document doc, Scanner in) throws Exception {
        System.out.print("Введите имя человека для удаления: ");
        String nameToDelete = in.nextLine();

        NodeList peopleList = doc.getElementsByTagName("person");
        boolean found = false;

        for (int i = 0; i < peopleList.getLength(); i++) {
            Node node = peopleList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getElementsByTagName("name").item(0).getTextContent();

                if (name.equalsIgnoreCase(nameToDelete)) {
                    node.getParentNode().removeChild(node);
                    found = true;
                }
            }
        }

        if (found) {
            saveChanges(doc);
            System.out.println("Человек успешно удален!");
        } else {
            System.out.println("Человек не найден!");
        }
    }

    private static void saveChanges(Document doc) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/lr8/birthdays.xml"));
        transformer.transform(source, result);
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/lr8/birthdays.xml");

            // Если файла нет — создаём новый
            if (!inputFile.exists()) {
                inputFile.getParentFile().mkdirs();
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.newDocument();

                Element root = doc.createElement("people");
                doc.appendChild(root);

                TransformerFactory tff = TransformerFactory.newInstance();
                Transformer tf = tff.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(inputFile);
                tf.transform(source, result);

                System.out.println("Файл birthdays.xml создан.");
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Scanner in = new Scanner(System.in);
            NodeList peopleList = doc.getElementsByTagName("person");

            printPeople(peopleList);

            System.out.print("\nДобавить нового человека? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                addNewPerson(doc, in);
            }

            System.out.print("\nНайти человека? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                searchPeople(doc, in);
            }

            System.out.print("\nУдалить человека? (Да/Нет): ");
            if (in.nextLine().equalsIgnoreCase("Да")) {
                deletePerson(doc, in);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}