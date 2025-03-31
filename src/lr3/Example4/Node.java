package lr3.Example4;

public class Node {

    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

}
