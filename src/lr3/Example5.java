package lr3;

import java.util.HashMap;
import java.util.Map;

public class Example5 {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Груша");
        map.put(1, "Голубика");
        map.put(2, "Яблоко");
        map.put(3, "Малина");
        map.put(4, "Манго");
        map.put(5, "Апельсин");
        map.put(6, "Грейпфрут");
        map.put(7, "Ананас");
        map.put(8, "Клубника");
        map.put(9, "Персик");

        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        if (map.containsKey(0)) {
            System.out.println("\nСтроки с ключом 0: " + String.join(", ", map.get(0)));
        }

        long product = 1;
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
            }
        }

        if (found) {
            System.out.println("\nПроизведение ключей, где длина строки > 5: " + product);
        } else {
            System.out.println("\nНет элементов с длиной строки > 5");
        }
    }

}
