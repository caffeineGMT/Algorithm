import java.util.Arrays;

public class MaxHeap {

    public static void swapAtIndex(int index1, int index2, int[] arr) {
        var temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void heapify(int[] arr) {
        var lastParentIndex = arr.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(arr, i);
        }

    }

    private static void heapify(int[] arr, int index) {
        var largeIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < arr.length && arr[leftIndex] > arr[largeIndex])
            largeIndex = leftIndex;
        var rightIndex = index * 2 + 2;
        if (rightIndex < arr.length && arr[rightIndex] > arr[largeIndex])
            largeIndex = rightIndex;
        if (largeIndex == index)
            return;
        swapAtIndex(index, largeIndex, arr);
        heapify(arr, largeIndex);
    }

    public static int getKthLargest(int[] arr, int k) {
        if (k < 0 || k > arr.length)
            throw new IllegalArgumentException();

        var heap = new Heap(10);
        for (var i : arr)
            heap.insert(i);

        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }

        return heap.remove();
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
