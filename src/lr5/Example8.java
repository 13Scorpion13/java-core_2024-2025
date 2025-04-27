package lr5;

import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите количество чисел в списке: ");
        int listSize = scanner.nextInt();
        List<Integer> numbers = IntStream.range(0, listSize)
                .mapToObj(i -> random.nextInt(1001))
                .collect(Collectors.toList());

        System.out.println("Сгенерированные числа: " + numbers);

        System.out.print("Введите минимальное значение для фильтрации: ");
        int threshold = scanner.nextInt();

        List<Integer> filteredNumbers = numbers.stream()
                .filter(n -> n > threshold)
                .collect(Collectors.toList());

        System.out.println("Числа больше " + threshold + ": " + filteredNumbers);
    }
}
