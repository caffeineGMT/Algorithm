import java.util.Arrays;
import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (stack1.empty() && stack2.empty())
            throw new IllegalStateException("queue is empty");
        if (stack2.empty())
            while (!stack1.empty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }

    public int peek() {
        if (stack1.empty() && stack2.empty())
            throw new IllegalStateException("queue is empty");
        if (stack2.empty())
            while (!stack1.empty())
                stack2.push(stack1.pop());
        return stack2.peek();
    }

    @Override
    public String toString() {
        return stack1.toString();
    }

    public static void main(String[] args) {
        var test = new QueueWithTwoStacks();
        test.enqueue(10);
        test.enqueue(20);
        test.enqueue(30);
        test.enqueue(40);
        test.dequeue();
        // test.dequeue();
        System.out.println(test.dequeue());
    }
}