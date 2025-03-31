package lr3.Example8;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Метод с циклами ===");
        Chikl iterativeList = new Chikl() ;
        iterativeList.createHead(new int[]{3, 2, 1});
        System.out.println("доббавить в начало: " + iterativeList);

        iterativeList.createTail(new int[]{4, 5, 6});
        System.out.println("добавить в конец: " + iterativeList);

        System.out.println("\n=== Рекурсивные методы ===");
        Recursia recursiveList = new Recursia();
        recursiveList.createHeadRec(new int[]{30, 20, 10});
        System.out.println("добавить в начало: " + recursiveList.toStringRec());

        recursiveList.createTailRec(new int[]{40, 50, 60});
        System.out.println("добавить в конец: " + recursiveList.toStringRec());
    }


}
