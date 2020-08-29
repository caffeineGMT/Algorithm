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

    public static void main(String[] args) {
        Queue<Integer> test = new ArrayDeque<>();
        test.add(10);
        test.add(20);
        test.add(30);
        test.add(60);
        test.add(70);
        reverser(test);
        System.out.println(test);
    }

}