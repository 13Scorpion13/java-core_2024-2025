package lr3.Example7;

public class Back {

    public static void main(String[] args) {

        Node head = null;
        Node tail = null;

        for (int i = 1; i <= 5; i++) {
            Node newNode = new Node(i);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        printList(head);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print("\n ");
            }
            current = current.next;
        }
        System.out.println(" \nnull");
    }

}
