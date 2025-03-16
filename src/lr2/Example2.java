package lr2;

import java.util.Scanner;

public class Example2 {

    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.println("Введите количество строк:");
        int rows = id.nextInt();
        System.out.println("Введите количество столбцов:");
        int cols = id.nextInt();

        int[][] array = new int[rows][cols];
        int nums = 1;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    array[i][j] = nums++;
                }
            }
            else {
                for (int j = cols - 1; j >= 0; j--) {
                    array[i][j] = nums++;
                }
            }
        }

        System.out.println("Массив, заполненный змейкой:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
