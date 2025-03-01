package lr1;

import java.util.Scanner;

public class example11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Как вас зовут?: ");
        String name = in.nextLine();

        System.out.println("Напишите свой год рождения: ");
        int year = in.nextInt();
        int age = 2025 - year;

        System.out.println(name);
        System.out.println("Ваш возраст: " + age);
        in.close();

    }

}
