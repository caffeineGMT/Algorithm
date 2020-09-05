import java.util.Arrays;

public class MaxHeap {
    public static void heapify(int[] arr) {
        if (arr.length == 0)
            return;
        for (int i = 0; i < arr.length; i++) {
            heapifyDown(i, arr);
            heapifyUp(i, arr);
        }
    }

    private static void heapifyDown(int index, int[] arr) {
        if (!hasLeftChild(index, arr))
            return;

        var leftChildIndex = index * 2 + 1;
        if (!hasRightChild(index, arr)) {
            if (arr[index] < arr[leftChildIndex])
                swapAtIndex(index, leftChildIndex, arr);
            return;
        }

        var rightChildIndex = index * 2 + 2;
        var largerChildIndex = arr[leftChildIndex] > arr[rightChildIndex] ? leftChildIndex : rightChildIndex;
        swapAtIndex(index, largerChildIndex, arr);
        heapifyDown(largerChildIndex, arr);
    }

    private static void heapifyUp(int index, int[] arr) {
        if (!hasParent(index, arr))
            return;
        var parentIndex = (index - 1) / 2;
        if (arr[index] > arr[parentIndex]) {
            swapAtIndex(index, parentIndex, arr);
            heapifyUp(parentIndex, arr);
        }
    }

    public static void swapAtIndex(int index1, int index2, int[] arr) {
        var temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static boolean hasLeftChild(int index, int[] arr) {
        return index * 2 + 1 <= arr.length - 1;
    }

    public static boolean hasRightChild(int index, int[] arr) {
        return index * 2 + 2 <= arr.length - 1;
    }

    public static boolean hasParent(int index, int[] arr) {
        return (index - 1) / 2 >= 0;
    }

    public static void main(String[] args) {
        int[] numbers = { 5, 3, 8, 4, 7, 2 };
        // heapify(numbers);
        System.out.println(Arrays.toString(numbers));
        heapify(numbers);
        // heapifyDown(1, numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
