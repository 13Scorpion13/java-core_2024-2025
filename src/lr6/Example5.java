package lr6;

import java.util.concurrent.*;

public class Example5 {

    public static void main(String[] args) throws Exception {
        int[] numbers = {3, 7, 2, 9, 5, 1, 8, 4, 6, 0, 12, 5};
        System.out.println("Массив: " + java.util.Arrays.toString(numbers));

        ExecutorService executor = Executors.newFixedThreadPool(4);
        int partSize = numbers.length / 4;

        Future<Integer>[] results = new Future[4];
        for (int i = 0; i < 4; i++) {
            int start = i * partSize;
            int end = (i == 3) ? numbers.length : start + partSize;

            results[i] = executor.submit(() -> {
                int max = numbers[start];
                for (int j = start; j < end; j++) {
                    if (numbers[j] > max) {
                        max = numbers[j];
                    }
                }
                return max;
            });
        }

        int finalMax = results[0].get();
        for (int i = 1; i < 4; i++) {
            int partMax = results[i].get();
            if (partMax > finalMax) {
                finalMax = partMax;
            }
        }

        executor.shutdown();
        System.out.println("Самый большой элемент массива: " + finalMax);
    }
}
