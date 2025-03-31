package lr3.Example8;

public class Chikl {

    protected Node head;
    protected Node tail;

    public void createHead(int[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            addFirst(values[i]);
        }
    }

    public void createTail(int[] values) {
        for (int value : values) {
            addLast(value);
        }
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
            return;
        }
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            addLast(value);
        } else {
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
    }

    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) return;

        current.next = current.next.next;
        if (current.next == null) {
            tail = current;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }

}
