package lr7.primerdorab;

import java.io.*;
import java.util.Scanner;

public class Primdor2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для записи: ");
        String data = scanner.nextLine();

        File file = new File("Example2.txt");

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
            System.out.println("Данные записаны в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader(file)) {
            char[] buffer = new char[1024];
            int charsRead = reader.read(buffer);
            System.out.println("Прочитано: " + new String(buffer, 0, charsRead));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}