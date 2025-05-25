package lr7.primer.Prim7;

import  java.io.*;
public class Prim7 {
    public static void main(String[] args) {
        // Создание объекта Person с правильными параметрами
        Person person = new Person("Ivan Ivanov", 30);

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("src/lr7/example7/person.ser");
            ObjectOutputStream out =
                    new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();

            System.out.println("Сериализованные данные сохранены в person.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
