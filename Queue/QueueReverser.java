import java.util.Queue;
import java.util.Stack;
import java.util.ArrayDeque;

public class QueueReverser {
    public static void reverser(Queue<Integer> queue) {
        // solution 1 only using queue, time complexity is pretty bad...
        // if (queue.isEmpty())
        // return;

        // Queue<Integer> temp = new ArrayDeque<>();
        // while (true) {
        // var item = queue.remove();
        // if (queue.isEmpty()) {
        // queue.add(item);
        // break;
        // }
        // temp.add(item);
        // }
        // reverser(temp);
        // while (!temp.isEmpty()) {
        // queue.add(temp.remove());
        // }
        // solution 2
        Stack<Integer> stack = new Stack();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void reverseFirstKItem(int k, Queue<Integer> queue) {
        // solution 1: using Stack
        if (k < 0)
            throw new IllegalArgumentException();
        Stack<Integer> stack = new Stack(); // stack is a class
        Queue<Integer> anotherQ = new ArrayDeque<>(); // queue is an interface

        for (int i = 0; i < k; i++)
            while (!queue.isEmpty())
                stack.push(queue.remove());
        while (!queue.isEmpty())
            anotherQ.add(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
        while (!anotherQ.isEmpty())
            queue.add(anotherQ.remove());
        // solution 2: using swap
        // solution 3: using size of a queue
        // if (k < 0 || k > queue.size())
        // throw new IllegalArgumentException();

        // java.util.Stack<Integer> stack = new Stack<>();

        // // Dequeue the first K elements from the queue
        // // and push them onto the stack
        // for (int i = 0; i < k; i++)
        // stack.push(queue.remove());

        // // Enqueue the content of the stack at the
        // // back of the queue
        // while (!stack.empty())
        // queue.add(stack.pop());

        // // Add the remaining items in the queue (items
        // // after the first K elements) to the back of the
        // // queue and remove them from the beginning of the queue
        // for (int i = 0; i < queue.size() - k; i++)
        // queue.add(queue.remove());
    }

    public static void main(String[] args) {
        Queue<Integer> test = new ArrayDeque<>();
        test.add(10);
        test.add(20);
        test.add(30);
        test.add(60);
        test.add(70);
        // reverser(test);
        reverseFirstKItem(5, test);
        System.out.println(test);
    }

}