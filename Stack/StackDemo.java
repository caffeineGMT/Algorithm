import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.empty();
        stack.peek();
        stack.search(10);
        System.out.println(stack);
    }
}