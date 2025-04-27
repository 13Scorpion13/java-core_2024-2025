package lr5;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> strings = List.of(
                "Напишите функцию",
                "Которая принимает на вход список",
                "строк и возвращает новый список",
                "Содержащий только те строки",
                "которые Начинаются с большой буквы"
        );

        System.out.println("Исходные строки:");
        strings.forEach(System.out::println);

        System.out.print("\nВведите подстроку для поиска: ");
        String substring = scanner.nextLine();

        List<String> filteredStrings = filterBySubstring(strings, substring);

        System.out.println("\nСтроки, содержащие \"" + substring + "\":");
        filteredStrings.forEach(System.out::println);
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}
