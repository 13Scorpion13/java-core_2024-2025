package lr1;

import java.util.Scanner;

public class example13 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите 1-ое целое число: ");
        int a = in.nextInt();

        System.out.println("Введите 2-ое целое число: ");
        int b = in.nextInt();
        int summa = a+b;

        System.out.println("Сумма: " + summa);
        in.close();

    }

}
