package lr5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = List.of(5, 7, 10, 189, 45, 67, 345, 7890, 89);

        System.out.println("Исходные числа: " + numbers);

        System.out.print("Введите максимальное значение: ");
        int threshold = scanner.nextInt();

        List<Integer> filteredNumbers = filterLessThan(numbers, threshold);

        System.out.println("Числа меньше " + threshold + ": " + filteredNumbers);
    }

    public static List<Integer> filterLessThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n < threshold)
                .collect(Collectors.toList());
    }
}
