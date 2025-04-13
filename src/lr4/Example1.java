package lr4;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите положительное число (размер массива): ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.out.println("Ошибка: размер массива должен быть ПОЛОЖИТЕЛЬНЫМ числом");
                return;
            }

            int[] array = new int[size];
            int positiveCount = 0;
            int positiveSum = 0;

            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size; i++) {
                try {
                    System.out.print("Элемент " + (i + 1) + ": ");
                    int num = scanner.nextInt();
                    array[i] = num;

                    if (num > 0) {
                        positiveCount++;
                        positiveSum += num;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введено не число. Попробуйте еще раз.");
                    scanner.next(); // Очистка буфера сканера
                    i--; // Повторяем ввод для этого же элемента
                }
            }

            if (positiveCount == 0) {
                System.out.println("Ошибка: в массиве нет положительных элементов");
            } else {
                double average = (double) positiveSum / positiveCount;
                System.out.printf("Среднее значение положительных элементов: %.2f\n", average);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введен неверный размер массива (требуется целое число)");
        } finally {
            scanner.close();
        }
    }
}
