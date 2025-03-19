package timus;

import java.util.Scanner;

public class task2100 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        int total = 0;

        for (int i = 0; i < n; i++) {
            String response = scanner.nextLine();
            if (response.contains("+one")) {
                total += 2;
            } else {
                total += 1;
            }
        }

        total += 2;

        if (total == 13) {
            total += 1;
        }

        int cost = total * 100;

        System.out.println(cost);

        scanner.close();
    }
}