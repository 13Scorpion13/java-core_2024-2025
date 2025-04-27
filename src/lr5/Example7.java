package lr5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> strings = List.of(
                "Кот",
                "Ёж",
                "Собака",
                "Уж",
                "Питон"
        );

        System.out.println("Исходные строки:");
        strings.forEach(System.out::println);

        System.out.print("\nВведите минимальную длину строки: ");
        int minLength = scanner.nextInt();

        List<String> filteredStrings = filterByLength(strings, minLength);

        System.out.println("\nСтроки длиной больше " + minLength + " символов:");
        filteredStrings.forEach(System.out::println);
    }

    public static List<String> filterByLength(List<String> strings, int minLength) {
        return strings.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}
