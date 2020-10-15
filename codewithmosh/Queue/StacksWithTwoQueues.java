import java.util.ArrayDeque;
import java.util.Queue;

public class StacksWithTwoQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    public StacksWithTwoQueues() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(int item) {
        queue1.add(item);
        top = item;
    }

    // the trick part of this 2-queue stack is to swap the reference of these 2
    // queues
    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        var counter = queue1.size();
        for (int i = 0; i < counter - 1; i++) {
            top = queue1.remove();
            queue2.add(top);
        }
        swapQueues();
        return queue1.remove();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return top;
    }

    public int size() {
        return queue1.size();
    }

    public boolean isEmpty() {
        return queue1.size() == 0;
    }

    private void swapQueues() {
        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public static void main(String[] args) {
        var test = new StacksWithTwoQueues();
        test.push(10);
        test.push(20);
        test.push(30);
        System.out.println(test.peek());
        // System.out.println(test.pop());
        // System.out.println(test.pop());
        System.out.println(test.queue1);
        System.out.println(test.queue2);
    }
}