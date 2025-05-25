package lr7.Example88;

import java.io.*;
import java.util.Scanner;

public class Example8 {

    public class SerializationDemo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите возраст: ");
            int age = scanner.nextInt();

            Person person = new Person(name, age);
            String fileName = "person.dat";

            // Сериализация
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(person);
                System.out.println("Объект сохранён в файл.");
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Десериализация
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                Person restoredPerson = (Person) ois.readObject();
                System.out.println("Восстановленный объект: " + restoredPerson);
            } catch (Exception e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }
}
