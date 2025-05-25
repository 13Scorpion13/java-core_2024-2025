package lr7;

import java.io.File;
import java.util.Scanner;

public class Example5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Размер файла: " + file.length() + " байт");
        } else {
            System.out.println("Файл не найден!");
        }
        scanner.close();
    }

}
