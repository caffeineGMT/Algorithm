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

    public void reverse() {
        if (isEmpty())
            return;
        if (first == last)
            return;
        Node p1 = null;
        Node p2 = first;
        Node p3 = p2.next;

        while (true) {
            p2.next = p1;
            if (p3 != null) {
                p1 = p2;
                p2 = p3;
                p3 = p3.next;
            } else
                break;
        }

        var temp = first;
        first = last;
        last = temp;
    }

    // find Kth node from the end in one pass
    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();
        if (k <= 0 || k > size)
            throw new IllegalArgumentException();
        var p1 = first;
        var p2 = first;
        for (int i = 0; i < k - 1; i++) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.value;
    }

    // Find the middle of a linked list in one pass. If the list has an even number
    // of nodes, there would be two middle nodes. (Note: Assume that you don’t know
    // the size of the list ahead of time.)
    public void printMiddle() {
        if (isEmpty())
            throw new IllegalStateException();
        var p1 = first;
        var p2 = first;
        while (p2 != last && p2.next != last) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if (p2 == last)
            System.out.println(p1.value);
        else
            System.out.println(p1.value + "," + p1.next.value);
    }

    // Check to see if a linked list has a loop
    // Hint: use two pointers (slow and fast) to traverse the list. Move the slow
    // pointer one step forward and the fast pointer two steps forward. If there’s a
    // loop, at some point, the fast pointer will meet the slow pointer and overtake
    // it. Draw this on a paper and see it for yourself. This algorithm is called
    // Floyd’s Cycle-finding Algorithm.

    public boolean hasLoop() {
        var slow = first;
        var fast = first;

        // need to check fast first before checking fast.next because fast itself can be
        // null, then null.next is an error
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.pushToFirst(10);
        list.pushToLast(20);
        list.pushToLast(30);

        // Get a reference to 30
        var node = list.last;

        list.pushToLast(40);
        list.pushToLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

    public static void main(String[] args) {
        var list = new LinkedList();
        list.pushToLast(10);
        list.pushToLast(20);
        list.pushToLast(30);
        list.pushToLast(40);
        list.pushToLast(50);
        list.pushToLast(60);
        list.pushToLast(70);
        list.pushToLast(80);
        // list.popLast();
        // list.popLast();
        // list.popLast();

        // System.out.println(list.getKthFromTheEnd(0));
        // list.printMiddle();
        // list.reverse();
        // System.out.println(Arrays.toString(list.toArray()));
        // System.out.println(list.first.value);
        var test = list.createWithLoop();
        System.out.println(list.hasLoop());
    }

}