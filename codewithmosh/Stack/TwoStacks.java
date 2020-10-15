
// Implement two stacks in one array. Support these operations: 
// push1() 
// push2() 
// pop1()
// pop2()
// isEmpty1()
// isEmpty2()
// isFull1()
// isFull2()
// Make sure your implementation is space efficient. 
// (hint: do not allocate the same amount of space by dividing the array in half.) 
import java.util.Arrays;

public class TwoStacks {
    private int[] arr;
    private int topIndex1;
    private int topIndex2;

    public TwoStacks(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity must be 1 or greater.");
        arr = new int[capacity];
        topIndex1 = -1;
        topIndex2 = arr.length;
    }

    public void push1(int item) {
        if (isFull1())
            throw new IllegalStateException();
        topIndex1++;
        arr[topIndex1] = item;
    }

    public int pop1() {
        if (isEmpty1())
            throw new IllegalStateException();
        var temp = arr[topIndex1];
        topIndex1--;
        return temp;
    }

    public boolean isEmpty1() {
        return topIndex1 == -1;
    }

    public boolean isFull1() {
        return topIndex1 + 1 == topIndex2;
    }

    public void push2(int item) {
        if (isFull2())
            throw new IllegalStateException();
        topIndex2--;
        arr[topIndex2] = item;
    }

    public int pop2() {
        if (isEmpty2())
            throw new IllegalArgumentException();
        var temp = arr[topIndex2];
        topIndex2--;
        return temp;
    }

    public boolean isFull2() {
        return topIndex2 - 1 == topIndex1;
    }

    public boolean isEmpty2() {
        return topIndex2 == arr.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        var test = new TwoStacks(4);
        test.push1(10);
        test.push1(10);
        test.push1(10);
        test.push2(30);
        test.push2(20);
        System.out.println(test);
    }

}