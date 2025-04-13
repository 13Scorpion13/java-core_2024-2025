package lr4;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Example3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива (1-100): ");
            int size = scanner.nextInt();

            if (size <= 0 || size > 100) {
                System.out.println("Ошибка: размер массива должен быть от 1 до 100");
                return;
            }

            byte[] array = new byte[size];
            byte sum = 0;

            System.out.println("Введите элементы массива (числа от -128 до 127):");
            for (int i = 0; i < size; i++) {
                try {
                    System.out.print("Элемент " + (i + 1) + ": ");
                    int input = scanner.nextInt();

                    if (input < Byte.MIN_VALUE || input > Byte.MAX_VALUE) {
                        throw new IllegalArgumentException("Ошибка: число " + input +
                                " выходит за границы типа byte (-128..127)");
                    }

                    array[i] = (byte)input;

                    int testSum = sum + array[i];
                    if (testSum > Byte.MAX_VALUE || testSum < Byte.MIN_VALUE) {
                        throw new ArithmeticException("Ошибка: переполнение при вычислении суммы");
                    }
                    sum = (byte)testSum;

                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введена строка вместо числа. Попробуйте снова.");
                    scanner.next(); // Надеюсь, это тут нужно)))
                    i--;
                } catch (IllegalArgumentException | ArithmeticException e) {
                    System.out.println(e.getMessage());
                    i--;
                }
            }

            System.out.println("Сумма элементов массива: " + sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введена строка вместо числа для размера массива");
        } finally {
            scanner.close();
        }
    }
}
