package lr7.primer.Prim8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Zadacha3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new FileReader ("src/lr7/example8/input.txt"));
        int lineCount = 0;
        while (reader.readLine() != null) {
            lineCount++;
        }
        reader.close();
        System.out.println("Количество строк в файле: " + lineCount);
    }
}
