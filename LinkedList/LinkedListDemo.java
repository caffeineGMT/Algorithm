import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        LinkedList generic = new LinkedList();
        generic.addLast(10);
        generic.addLast(20);
        generic.addLast(10);
        generic.addFirst(5);
        generic.removeLast();
        generic.contains(10);
        generic.indexOf(10);
        generic.size();
        generic.toArray();
        generic.getClass();
    }

}