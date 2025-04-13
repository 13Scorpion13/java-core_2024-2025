package lr4;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Example2 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Исходная матрица:");
            printMatrix(matrix);

            System.out.print("Введите номер столбца (отсчет с 0): ");
            int columnNumber = scanner.nextInt();

            if (columnNumber < 0 || columnNumber >= matrix[0].length) {
                throw new IllegalArgumentException("Ошибка: столбца с номером " + columnNumber + " не существует");
            }

            System.out.println("Столбец " + columnNumber + ":");
            printColumn(matrix, columnNumber);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введена строка вместо числа");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void printColumn(int[][] matrix, int columnNumber) {
        for (int[] row : matrix) {
            System.out.println(row[columnNumber]);
        }
    }
}
