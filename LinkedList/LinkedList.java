import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
            next = null;
        }
    }

    private Node first;
    private Node last;
    private int size;

    private boolean isEmpty() {
        return first == null;
        first.
    }

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void pushToFirst(int x) {
        Node data = new Node(x);
        if (isEmpty()) {
            first = data;
            last = data;
        } else {
            data.next = first;
            first = data;
        }
        size++;
    }

    public void pushToLast(int x) {
        Node data = new Node(x);
        if (isEmpty()) {
            first = data;
            last = data;
        } else {
            last.next = data;
            last = data;
        }
        size++;
    }

    public void popFirst() {
        // redirect first reference, and remove the link so that garbage collector could
        // remove it from memory
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = null;
            last = null;
        }
        Node temp = first;
        first = first.next;
        temp.next = null;
        size--;
    }

    public void popLast() {
        // walk thru the list, find the second last and relink
        if (first == null)
            throw new NoSuchElementException();
        if (first == last) {
            first = null;
            last = null;
            size--;
            return;
        }
        Node temp = first;
        while (temp.next != last) {
            temp = temp.next;
        }
        last = temp;
        last.next = null;
        size--;
    }

    public int peekFirst() {
        // return the value from first reference
        return first.value;
    }

    public int peekLast() {
        // return the value from last reference
        return last.value;
    }

    public int indexOf(int target) {
        if (first == null) {
            return -1;
        }
        int index = 0;
        Node pointer = first;

        while (pointer != null) {
            if (pointer.value == target) {
                return index;
            }
            pointer = pointer.next;
            index++;
        }
        return -1;
    }

    public boolean contain(int target) {
        // recycle some logic from other method
        return indexOf(target) != -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] temp = new int[size];
        Node pointer = first;
        for (int i = 0; i < size; i++) {
            temp[i] = pointer.value;
            pointer = pointer.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        var list = new LinkedList();
        // list.pushToLast(10);
        // list.pushToLast(20);
        // list.pushToLast(30);
        // list.popLast();
        // list.popLast();
        // list.popLast();
        System.out.println(Arrays.toString(list.toArray()));

    }

}