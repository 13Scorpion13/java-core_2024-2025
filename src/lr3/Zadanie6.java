package lr3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeSet;

public class Zadanie6 {

    public static void main(String[] args) {
        final int N = 5000000;

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();


        for (int i = 0; i < N; i++) {
            arrayDeque.add(i);
            arrayList.add(i);
            treeSet.add(i); // TreeSet автоматически сортирует элементы
        }

        // Добавление в начало
        long startTime = System.nanoTime();
        arrayDeque.addFirst(-1);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время добавления в начало ArrayDeque: " + duration + " мс");

        startTime = System.nanoTime();
        arrayList.add(0, -1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время добавления в начало ArrayList: " + duration + " мс");

        // Для TreeSet нет операции "добавление в начало", только общее добавление
        startTime = System.nanoTime();
        treeSet.add(-1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время добавления в TreeSet: " + duration + " мс");

        // Добавление в конец
        startTime = System.nanoTime();
        arrayDeque.addLast(N);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время добавления в конец ArrayDeque: " + duration + " мс");

        startTime = System.nanoTime();
        arrayList.add(N);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время добавления в конец ArrayList: " + duration + " мс");

        // Для TreeSet нет операции "добавление в конец", только общее добавление
        startTime = System.nanoTime();
        treeSet.add(N);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время добавления в TreeSet (конец): " + duration + " мс");

        // Добавление в середину
        startTime = System.nanoTime();
        arrayList.add(N / 2, -2);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время добавления в середину ArrayList: " + duration + " мс");
// Добавление в середину ArrayList
        startTime = System.nanoTime();
        arrayList.add(arrayList.size() / 2, -2);  // -2 - элемент для вставки
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время добавления в середину ArrayList: " + duration + " мс");

// Удаление из середины ArrayList
        startTime = System.nanoTime();
        arrayList.remove(arrayList.size() / 2);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("Время удаления из середины ArrayList: " + duration + " мс");
        // Для TreeSet нет операции "добавление в середину"
        System.out.println("TreeSet не поддерживает добавление в середину");

        // Удаление из начала
        startTime = System.nanoTime();
        arrayDeque.removeFirst();
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время удаления из начала ArrayDeque: " + duration + " мс");

        startTime = System.nanoTime();
        arrayList.remove(0);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время удаления из начала ArrayList: " + duration + " мс");

        startTime = System.nanoTime();
        treeSet.remove(treeSet.first());
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время удаления первого элемента TreeSet: " + duration + " мс");

        // Удаление из конца
        startTime = System.nanoTime();
        arrayDeque.removeLast();
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время удаления из конца ArrayDeque: " + duration + " мс");

        startTime = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время удаления из конца ArrayList: " + duration + " мс");

        startTime = System.nanoTime();
        treeSet.remove(treeSet.last());
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время удаления последнего элемента TreeSet: " + duration + " мс");

        // Удаление из середины
        startTime = System.nanoTime();
        arrayList.remove(N / 2);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время удаления из середины ArrayList: " + duration + " мс");

        // Для TreeSet нет операции "удаление из середины" по индексу
        System.out.println("TreeSet не поддерживает удаление из середины по индексу");

        // Получение элемента
        startTime = System.nanoTime();
        arrayList.get(N / 2);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 5_000_000.0;
        System.out.println("Время получения элемента по индексу ArrayList: " + duration + " мс");

        // TreeSet не поддерживает доступ по индексу
        System.out.println("TreeSet не поддерживает доступ по индексу");
    }

}
