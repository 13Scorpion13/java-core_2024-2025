package lr5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = List.of(10, 15, 20, 25, 30, 35, 40, 45, 50);

        System.out.println("Исходные числа: " + numbers);

        System.out.print("Введите число для проверки делимости: ");
        int divisor = scanner.nextInt();

        List<Integer> divisibleNumbers = filterDivisibleNumbers(numbers, divisor);

        System.out.println("Числа, делящиеся на " + divisor + " без остатка: " + divisibleNumbers);
    }

    public static List<Integer> filterDivisibleNumbers(List<Integer> numbers, int divisor) {
        return numbers.stream()
                .filter(n -> n % divisor == 0)
                .collect(Collectors.toList());
    }
}
