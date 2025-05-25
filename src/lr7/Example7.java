package lr7;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example7 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine();
        System.out.println("Введите текст (для завершения введите 'end'):");

        StringBuilder text = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            text.append(line).append("\n");
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text.toString());
            System.out.println("Записано символов: " + text.length());
        }
        scanner.close();
    }

}
