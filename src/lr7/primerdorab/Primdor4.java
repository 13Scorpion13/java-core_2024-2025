package lr7.primerdorab;

import java.io.*;
import java.util.Scanner;

public class Primdor4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос данных у пользователя
        System.out.println("Введите текст для записи в файл:");
        String data = scanner.nextLine();

        String fileName = "example_file.txt";

        // Запись данных в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            scanner.close();
            return;
        }

        // Чтение данных из файла
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            char[] buffer = new char[1024];
            int charRead = reader.read(buffer);
            String readData = new String(buffer, 0, charRead);
            System.out.println("Прочитанные данные: " + readData);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // Запрос подтверждения на удаление файла
        System.out.println("Удалить файл? (y/n)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("y")) {
            if (new File(fileName).delete()) {
                System.out.println("Файл удален: " + fileName);
            } else {
                System.out.println("Не удалось удалить файл: " + fileName);
            }
        } else {
            System.out.println("Файл сохранен: " + fileName);
        }

        scanner.close();
    }

}
