import java.util.Arrays;

public class PriorityQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int count;

    public PriorityQueue(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(int item) {
        // edge case: empty queue
        if (isEmpty()) {
            rear++;
            arr[rear] = item;
            count++;
            return;
        }
        if (isFull())
            throw new IllegalStateException();
        // find index
        for (int i = front; i <= rear; i++) {
            if (item < arr[i]) {
                for (int j = rear; j >= i; j--)
                    arr[j + 1] = arr[j];
                arr[i] = item;
                rear++;
                count++;
                return;
            }
        }
        // edge case: insert at the end
        rear++;
        arr[rear] = item;
        count++;

        // solution 2: this is walking down the list from the back
        // int i;
        // for (i = count - 1; i >= 0; i--) {
        // if (arr[i] > item)
        // arr[i + 1] = arr[i];
        // else
        // break;
        // }
        // arr[i + 1] = item;
        // count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("empty queue");
        count--;
        return arr[front++];
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
        var test = new PriorityQueue(10);
        test.enqueue(10);
        test.enqueue(20);
        test.enqueue(30);
        test.enqueue(40);
        test.enqueue(80);
        test.dequeue();
        test.dequeue();
        test.dequeue();
        test.dequeue();
        test.dequeue();
        System.out.println(test.dequeue());
    }

}