import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] arr) {
        if (arr == null)
            return;

        for (int i = 0; i < arr.length; i++) {
            var minIndex = min(i, arr.length - 1, arr);
            swap(minIndex, i, arr);
        }
    }

    public static void swap(int a, int b, int[] arr) {
        var temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public static int min(int start, int end, int[] arr) {
        var minResult = arr[start];
        var minIndex = start;
        for (int i = start; i <= end; i++)
            if (arr[i] < minResult) {
                minResult = arr[i];
                minIndex = i;
            }

        return minIndex;
    }

    public static void main(String[] args) {
        var arr = new int[] { 5, 4, 3, 2, 1 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
