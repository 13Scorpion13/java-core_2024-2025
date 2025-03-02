package timus;

import java.util.Scanner;

public class task1409 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int Harry = in.nextInt();
        int Larry = in.nextInt();

        int all = Harry + Larry - 1;
        int HarryL = all - Harry;
        int LarryL = all - Larry;

        System.out.println(HarryL + " " + LarryL);
    }
} 
