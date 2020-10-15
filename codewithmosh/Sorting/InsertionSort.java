import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr) {
        if (arr == null)
            return;

        for (int i = 1; i < arr.length; i++) {
            var temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                } else {
                    arr[j + 1] = temp;
                    break;
                }
            }
        }

        // solution 2: while loop
        // for (var i = 1; i < arr.length; i++) {
        // var current = arr[i];
        // var j = i - 1;
        // while (j >= 0 && arr[j] > current) {
        // arr[j + 1] = arr[j];
        // j--;
        // }
        // arr[j + 1] = current;
        // }
    }

    public static void swap(int a, int b, int[] arr) {
        var temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public static void main(String[] args) {
        var numbers = new int[] { 8, 2, 4, 1, 3, 3 };
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}