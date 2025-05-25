package lr7.primerdorab;

import java.io.File;
import java.util.Scanner;

public class Primdor1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь для папки (например, src/lab7/folder): ");
        String folderPath = scanner.nextLine();

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println("Папка создана: " +
                    folder.getAbsolutePath());
        }
        System.out.print("Введите имя файла (например, test.txt): ");
        String fileName = scanner.nextLine();
        File file = new File(folder, fileName);

        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getName());
            }
            System.out.println("Нажмите Enter для удаления файла и папки...");
            scanner.nextLine();

            file.delete();
            System.out.println("Файл удален: " + file.getName());
            folder.delete();
            System.out.println("Папка удалена: " + folder.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
