package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Example4 {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        System.out.println("Исходные числа:");
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100); // чтобы можно было проверить в голове))
            numbers.add(num);
            System.out.print(num + " ");
        }

        List<Integer> squaredNumbers = squareNumbers(numbers);

        System.out.println("\n\nКвадраты чисел:");
        squaredNumbers.forEach(n -> System.out.print(n + " "));
    }
    public static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }
}
