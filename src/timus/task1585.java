package timus;

import java.util.Scanner;

public class task1585 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        int emperorCount = 0;
        int macaroniCount = 0;
        int littleCount = 0;

        for (int i = 0; i < n; i++) {
            String penguinType = scanner.nextLine();
            if (penguinType.equals("Emperor Penguin")) {
                emperorCount++;
            }
            else if (penguinType.equals("Macaroni Penguin")) {
                macaroniCount++;
            }
            else if (penguinType.equals("Little Penguin")) {
                littleCount++;
            }
        }

        String PopularPenguin = "";
        if (littleCount > emperorCount && littleCount > macaroniCount) {
            PopularPenguin = "Little Penguin";
        }
        else if (emperorCount > littleCount && emperorCount > macaroniCount) {
            PopularPenguin = "Emperor Penguin";
        }
        else {
            PopularPenguin = "Macaroni Penguin";
        }

        System.out.println(PopularPenguin);

        scanner.close();
    }
}