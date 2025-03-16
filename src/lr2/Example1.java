package lr2;

import java.util.Scanner;
import java.util.Random;

public class Example1 {

    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = id.nextInt();
        System.out.println("Введён размер массива "+ size);
        int[] nums = new int[size];
        Random random = new Random();

        System.out.println("Сгенерированный массив:");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
            System.out.println("Элемент массива ["+i+"] = " + nums[i]);
        }

        int minnums = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minnums) {
                minnums = nums[i];
            }
        }

        System.out.println("Минимальное значение в массиве: " + minnums);
        System.out.print("Индексы элементов с минимальным значением: ");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minnums) {
                System.out.print(i + " ");
            }
        }
    }

}
