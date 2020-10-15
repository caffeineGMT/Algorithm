import java.util.Arrays;

public class LinkedListQueue {
    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    public void enqueue(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        var temp = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            temp.next = null;
        }
        count--;
        return temp.value;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return head.value;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        var temp = new int[size()];
        var cur = head;
        for (int i = 0; i < temp.length; i++) {
            temp[i] = cur.value;
            cur = cur.next;
        }
        return Arrays.toString(temp);
    }

    public static void main(String[] args) {
        var test = new LinkedListQueue();
        test.enqueue(10);
        test.enqueue(20);
        test.enqueue(30);
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test);
    }
}