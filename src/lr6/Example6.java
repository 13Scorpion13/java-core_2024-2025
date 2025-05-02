package lr6;
import java.util.concurrent.*;
public class Example6 {

    public static void main(String[] args) throws Exception {
        int[] numbers = {3, 7, 2, 9, 5, 1, 8, 4, 6, 0, 12, 5};
        int sum = parallelSum(numbers);
        System.out.println("Массив: " + java.util.Arrays.toString(numbers));
        System.out.println("Сумма элементов: " + sum);
    }
    public static int parallelSum(int[] array) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        int chunkSize = array.length / 4;
        Future<Integer>[] partialSums = new Future[4];

        for (int i = 0; i < 4; i++) {
            final int start = i * chunkSize;
            final int end = (i == 3) ? array.length : start + chunkSize;

            partialSums[i] = executor.submit(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum;
            });
        }

        int totalSum = 0;
        for (Future<Integer> future : partialSums) {
            totalSum += future.get();
        }

        executor.shutdown();
        return totalSum;
    }
}
