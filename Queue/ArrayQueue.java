import java.util.Arrays;

public class ArrayQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("capacity cannot be negative");
        arr = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException("full queue");
        if (rear == arr.length - 1) {
            rear = 0;
            arr[rear] = item;
            count++;
            return;
        }
        rear++;
        arr[rear] = item;
        count++;

        // a smarter solution to map rear pointer back to front
        // if (isFull())
        // throw new IllegalStateException();

        // items[rear] = item;
        // rear = (rear + 1) % items.length;
        // count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("empty queue");
        if (front == arr.length - 1) {
            var temp = arr[arr.length - 1];
            arr[arr.length - 1] = 0;
            front = 0;
            count--;
            return temp;
        }
        var temp = arr[front];
        arr[front] = 0;
        front++;
        count--;
        return temp;

        // a smarter solution to map front pointer back to start
        // var item = items[front];
        // items[front] = 0;
        // front = (front + 1) % items.length;
        // count--;

        // return item;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("empty queue");
        return arr[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == arr.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        var test = new ArrayQueue(4);
        test.enqueue(10);
        test.enqueue(20);
        test.enqueue(30);
        test.enqueue(40);
        test.dequeue();
        test.enqueue(50);
        test.dequeue();
        test.dequeue();
        test.dequeue();
        test.dequeue();
        test.dequeue();
        // test.enqueue(50);
        // test.enqueue(50);
        System.out.println(test);
    }

}