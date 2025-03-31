package lr3.Example8;

public class Recursia extends Chikl{

    public void createHeadRec(int[] values) {
        head = createHeadRecHelper(values, values.length - 1);
        updateTail();
    }

    private Node createHeadRecHelper(int[] values, int index) {
        if (index < 0) return null;
        Node newNode = new Node(values[index]);
        newNode.next = createHeadRecHelper(values, index - 1);
        return newNode;
    }

    // Рекурсивное создание с хвоста
    public void createTailRec(int[] values) {
        head = createTailRecHelper(values, 0);
        updateTail();
    }

    private Node createTailRecHelper(int[] values, int index) {
        if (index >= values.length) return null;
        Node newNode = new Node(values[index]);
        newNode.next = createTailRecHelper(values, index + 1);
        return newNode;
    }

    // Рекурсивное строковое представление
    public String toStringRec() {
        return toStringRecHelper(head);
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        return node.data + (node.next != null ? " -> " : "") + toStringRecHelper(node.next);
    }

    // Обновление указателя на хвост
    private void updateTail() {
        tail = head;
        if (tail != null) {
            while (tail.next != null) {
                tail = tail.next;
            }
        }
    }

}
