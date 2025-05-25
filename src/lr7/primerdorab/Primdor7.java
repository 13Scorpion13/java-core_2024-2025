package lr7.primerdorab;

import java.io.*;
import java.util.Scanner;

public class Primdor7 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);
        if (file.exists()) {
            System.out.print("Файл существует. Перезаписать? (y/n): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                System.out.println("Отмена операции.");
                return;
            }
        }

        System.out.println("Введите текст (для завершения введите 'end' на новой строке):");
        StringBuilder text = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            text.append(line).append("\n");
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text.toString());
            System.out.println("Записано символов: " + text.length());
        }
        scanner.close();
    }

}
