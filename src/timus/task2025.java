package timus;

import java.util.Scanner;

public class task2025 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int baseSize = n / k;
            int largerTeams = n % k;
            int smallTeams = k - largerTeams;

            long fights = (long)smallTeams * baseSize * (n - baseSize)
                    + (long)largerTeams * (baseSize + 1) * (n - baseSize - 1);
            fights /= 2;

            System.out.println(fights);
        }
    }
}