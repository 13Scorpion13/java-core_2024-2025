package timus;

import java.util.Scanner;

public class task1601 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        while (scanner.hasNextLine()) {
            input.append(scanner.nextLine()).append("\n");
        }
        scanner.close();

        String fixedMessage = fixCaps(input.toString());
        System.out.println(fixedMessage);
    }

    private static String fixCaps(String text) {
        StringBuilder result = new StringBuilder();
        boolean newSentence = true;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if (newSentence) {
                    result.append(Character.toUpperCase(c));
                    newSentence = false;
                } else {
                    result.append(Character.toLowerCase(c));
                }
            } else {
                result.append(c);
                if (c == '.' || c == '!' || c == '?') {
                    newSentence = true;
                }
            }
        }
        return result.toString();
    }
}
