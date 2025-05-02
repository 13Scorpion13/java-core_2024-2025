package timus;
import java.util.Scanner;

public class task1880 {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        int n = scaner.nextInt();
        String k = scaner.next();
        int exclamations = k.length();
        int result = 1;
        while (n > 0) {
            result *= n;
            n -= exclamations;
        }
        System.out.println(result);
    }
}
