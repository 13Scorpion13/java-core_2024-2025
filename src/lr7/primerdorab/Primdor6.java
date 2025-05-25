package lr7.primerdorab;

import java.io.*;
import java.util.Scanner;
public class Primdor6 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();
        System.out.print("Введите слово для поиска: ");
        String word = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            boolean found = false;

            System.out.println("Результаты поиска:");
            while ((line = reader.readLine()) != null) {
                if (line.contains(word)) {
                    System.out.printf("Строка %d: %s%n", lineNumber, line);
                    found = true;
                }
                lineNumber++;
            }

            if (!found) {
                System.out.println("Совпадений не найдено.");
            }
        }
        scanner.close();
    }

}
