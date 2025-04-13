package lr4.primer;

public class Prim5 {

    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("3");
        } catch (RuntimeException e) {
            System.out.println("1");
        }
        System.out.println("2");
    }

}
