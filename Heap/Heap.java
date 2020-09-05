import java.util.Arrays;

public class Heap {
    private int[] arr;
    private int count;

    public Heap(int capacity) {
        arr = new int[capacity];
        count = 0;
    }

    public void insert(int item) {
        if (isFull())
            throw new IllegalStateException();
        arr[count] = item;
        bubbleUp(count);
        count++;
    }

    private void bubbleUp(int childIndex) {
        if (childIndex == 0)
            return;

        var parentIndex = (childIndex - 1) / 2;
        if (arr[childIndex] > arr[parentIndex]) {
            swapAtIndex(childIndex, parentIndex);
            bubbleUp(parentIndex);
        }
    }

    // solution 2: iteration
    // private void bubbleUp() {
    // var index = size - 1;
    // while (index > 0 && items[index] > items[parent(index)]) {
    // swap(index, parent(index));
    // index = parent(index);
    // }
    // }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();
        var root = arr[0];
        arr[0] = arr[count - 1];
        bubbleDown(0);
        count--;
        return root;
    }

    private void bubbleDown(int parentIndex) {
        if (isLeaf(parentIndex))
            return;

        var leftChildIndex = parentIndex * 2 + 1;
        var rightChildIndex = parentIndex * 2 + 2;

        if (hasSingleChild(parentIndex)) {
            if (arr[parentIndex] < arr[leftChildIndex])
                swapAtIndex(parentIndex, leftChildIndex);
            return;
        }

        if (arr[parentIndex] < arr[leftChildIndex] || arr[parentIndex] < arr[rightChildIndex]) {
            var largerChildAtIndex = arr[leftChildIndex] > arr[rightChildIndex] ? leftChildIndex : rightChildIndex;
            swapAtIndex(parentIndex, largerChildAtIndex);
            bubbleDown(largerChildAtIndex);
        }
    }

    public boolean isLeaf(int parentIndex) {
        var leftChildIndex = parentIndex * 2 + 1;
        var rightChildIndex = parentIndex * 2 + 2;
        return (leftChildIndex > (count - 1)) && (rightChildIndex > (count - 1));
    }

    public boolean hasSingleChild(int parentIndex) {
        var leftChildIndex = parentIndex * 2 + 1;
        var rightChildIndex = parentIndex * 2 + 2;
        return leftChildIndex <= count - 1 && rightChildIndex > count - 1;
    }

    public void swapAtIndex(int index1, int index2) {
        var temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == arr.length;
    }

    @Override
    public String toString() {
        var temp = new int[count];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }
        return Arrays.toString(temp);
    }

    public static void main(String[] args) {
        var test = new Heap(10);
        test.insert(15);
        test.insert(10);
        test.insert(3);
        test.insert(8);
        test.insert(12);
        test.insert(9);
        test.insert(4);
        test.insert(1);
        test.insert(24);
        System.out.println(Arrays.toString(test.arr));
        System.out.println(test.remove());
        System.out.println(test.remove());
        System.out.println(Arrays.toString(test.arr));
        System.out.println(test);
    }

}
