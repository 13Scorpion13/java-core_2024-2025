package lr7.primerdorab;

import java.io.File;
import java.util.Scanner;

public class Primdor5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String path = scanner.nextLine();

        File file = new File(path);
        if (file.exists()) {
            System.out.println("Размер файла: " + file.length() + " байт");
        } else {
            System.out.println("Файл не существует!");
        }
        scanner.close();
    }

}
