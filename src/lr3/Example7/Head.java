package lr3.Example7;

public class Head {

    public static void main(String[] args) {

        Node head = null;

        for (int i = 5; i >= 1; i--) {
            Node newNode = new Node(i);
            newNode.next = head;
            head = newNode;
        }

        printList(head);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" \n");
            }
            current = current.next;
        }
        System.out.println(" \nnull");
    }

}