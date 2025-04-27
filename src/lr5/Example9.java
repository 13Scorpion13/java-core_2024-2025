package lr5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строки через запятую:");
        String input = scanner.nextLine();

        List<String> strings = List.of(input.split(","));
        System.out.println("\nИсходные строки:");
        strings.forEach(s -> System.out.println(s.trim()));

        List<String> lettersOnly = filterLettersOnly(strings);

        System.out.println("\nСтроки только с буквами:");
        lettersOnly.forEach(System.out::println);
    }

    public static List<String> filterLettersOnly(List<String> strings) {
        return strings.stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty() && s.matches("^[a-zA-Zа-яА-Я]+$"))
                .collect(Collectors.toList());
    }
}
