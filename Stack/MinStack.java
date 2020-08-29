import java.util.Stack;

// Design a stack that supports push, pop and retrieving the minimum value in constant time. 
// Solution: https://www.youtube.com/watch?v=nGwn8_-6e7w
// Essentially it is saving the min state when pushing each item to the main stack. However, the space can be optimized if not pushing each state to minStack
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        stack.push(value);
        if (minStack.empty() || value < minStack.peek())
            minStack.push(value);
    }

    public int pop() {
        var top = stack.pop();
        if (top == minStack.peek())
            minStack.pop();
        return top;
    }

    public int min() {
        return minStack.peek();
    }

    @Override
    public String toString() {
        return minStack.toString();
    }

    public static void main(String[] args) {
        var test = new MinStack();
        test.push(10);
        test.push(20);
        test.push(30);
        test.push(8);
        test.push(1);
        test.pop();
        // test.pop();
        System.out.println(test.min());
        System.out.println(test.toString());
    }
}