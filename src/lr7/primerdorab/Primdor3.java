package lr7.primerdorab;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Primdor3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных с консоли
        System.out.println("Введите текст для записи в файл:");
        String data = scanner.nextLine();

        String fileName = "src/lr7/example3/example_file.txt";

        // Создание директории, если она не существует
        File directory = new File("src/lr7/example3");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Запись данных в файл
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data);
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            scanner.close();
            return;
        }

        // Чтение данных из файла
        try (FileReader reader = new FileReader(fileName)) {
            char[] buffer = new char[1024];
            int charRead = reader.read(buffer);
            String readData = new String(buffer, 0, charRead);
            System.out.println("Прочитанные данные: " + readData);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // Подтверждение удаления файла
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
