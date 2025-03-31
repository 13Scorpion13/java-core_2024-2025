package timus;

import java.util.Scanner;

public class task1263 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество кандидатов: ");
        int numCandidates = scanner.nextInt();

        System.out.print("Введите количество избирателей: ");
        int numVoters = scanner.nextInt();

        int[] votesCount = new int[numCandidates];

        System.out.println("\nВведите номера кандидатов, за которых проголосовали " +
                numVoters + " избирателей:");

        for (int i = 0; i < numVoters; i++) {
            int candidateNumber = scanner.nextInt();
            votesCount[candidateNumber - 1]++; // Корректировка индекса
        }

        System.out.println("\nРезультаты выборов:");
        for (int i = 0; i < numCandidates; i++) {
            double percentage = (double) votesCount[i] / numVoters * 100;
            System.out.printf("Кандидат №%d: %.2f%%\n", (i + 1), percentage);
        }

        scanner.close();
    }

}
