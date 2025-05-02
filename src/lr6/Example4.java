package lr6;

public class Example4 {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            final int threadNum = i;
            new Thread(() -> {
                System.out.println("Поток " + threadNum);
            }).start();
        }
    }
}
