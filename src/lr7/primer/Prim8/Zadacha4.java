package lr7.primer.Prim8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zadacha4 {
    public static void main(String[] args) {
        // Указываем пути к файлам
        String inputPath = "src/lr7/example8/input2.txt";
        String outputPath = "src/lr7/example8/output2.txt";

        try (FileReader reader = new FileReader(inputPath);
             FileWriter writer = new FileWriter(outputPath)) {

            int c;
            // Копируем содержимое посимвольно
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }

            System.out.println("Файл скопирован успешно!");

        } catch (IOException e) {
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }

}
