package lr1;

import java.util.Scanner;

public class example6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите фамилию: ");
        String finame = in.nextLine();

        System.out.println("Введите имя: ");
        String name = in.nextLine();

        System.out.println("Введите отчество: ");
        String fathname = in.nextLine();

        System.out.println("Hello " + finame + ", " + name + ", " + fathname);
        in.close();
    }

}
