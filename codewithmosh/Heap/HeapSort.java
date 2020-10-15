import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] numbers = { 5, 3, 10, 1, 4, 2 };
        var heap = new Heap(10);
        for (var number : numbers)
            heap.insert(number);

        // descending order
        // for (int i = 0; i < numbers.length; i++) {
        // numbers[i] = heap.remove();
        // }
        // System.out.println(Arrays.toString(numbers));

        // ascending order
        for (int i = numbers.length - 1; i >= 0; i--) {
            numbers[i] = heap.remove();
        }
        System.out.println(Arrays.toString(numbers));
    }

}
