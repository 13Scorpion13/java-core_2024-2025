package lr2;

import java.util.Scanner;

public class Example3 {

    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);

        System.out.println("Введите текст для шифрования:");
        String text = id.nextLine();

        System.out.println("Введите ключ:");
        int shift = id.nextInt();
        id.nextLine();

        String encryptedText = getEncryptString(text, shift);
        System.out.println("Текст после преобразования: " + encryptedText);

        System.out.println("Выполнить обратное преобразование? (y/n)");
        String answer = id.nextLine();

        if (answer.equalsIgnoreCase("y")) {

            String decryptedText = getEncryptString(encryptedText, -shift);
            System.out.println("Текст после обратного преобразования: " + decryptedText);
        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ.");
        }

        id.close();
    }

    public static String getEncryptString(String encryptString, int shift) {
        char[] arrayChar = encryptString.toCharArray();
        long[] arrayInt = new long[arrayChar.length];
        char[] arrayCharNew = new char[arrayChar.length];

        for (int i = 0; i < arrayChar.length; i++) {
            arrayInt[i] = arrayChar[i] + shift;
            arrayCharNew[i] = (char) arrayInt[i];
        }

        return new String(arrayCharNew);
    }

}
