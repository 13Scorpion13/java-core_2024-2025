package lr5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строки через запятую: ");
        String input = scanner.nextLine();

        List<String> strings = List.of(input.split(","));

        System.out.println("\nИсходный список строк:");
        strings.forEach(System.out::println);

        List<String> capitalizedStrings = filterCapitalizedStrings(strings);

        System.out.println("\nСтроки, начинающиеся с заглавной буквы:");
        capitalizedStrings.forEach(System.out::println);
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}
