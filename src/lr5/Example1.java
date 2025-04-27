package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = in.nextInt();

        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(arr));

        int[] evenNumbers = filterEvenNumbers(arr);

        System.out.println("Массив с четными числами: ");
        System.out.println(Arrays.toString(evenNumbers));
    }

    public static int[] filterEvenNumbers(int[] arr) {
        return Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                .toArray();
    }
}

