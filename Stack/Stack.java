import java.util.Arrays;

public class Stack {
    private int[] arr;
    private int count;

    public Stack() {
        arr = new int[1];
        count = 0;
    }

    public void push(int value) {
        if (count == arr.length) {
            var temp = new int[count * 2];
            for (int i = 0; i < count; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[count] = value;
        count++;
    }

    public int pop() {
        if (count == 0)
            throw new IllegalStateException();
        count--;
        return arr[count];
    }

    public int peek() {
        if (count == 0)
            throw new IllegalStateException();
        return arr[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(arr, 0, count);
        return Arrays.toString(content);
    }

    public static void main(String[] args) {
        var stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.err.println(stack);
    }
}
