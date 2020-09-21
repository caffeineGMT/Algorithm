import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] arr) {
        if (arr.length < 2)
            return;

        var middle = arr.length / 2;

        int[] left = new int[middle];
        for (var i = 0; i < middle; i++)
            left[i] = arr[i];

        int[] right = new int[arr.length - middle];
        for (var i = middle; i < arr.length; i++)
            right[i - middle] = arr[i];

        sort(left);
        sort(right);
        merge(arr, left, right);
    }

    public static int[] merge(int[] input, int[] left, int[] right) {
        var p1 = 0;
        var p2 = 0;
        var i = 0;

        while (p1 < left.length && p2 < right.length) {
            if (left[p1] < right[p2]) {
                input[i] = left[p1];
                p1++;
            } else {
                input[i] = right[p2];
                p2++;
            }

            i++;
        }

        while (p1 < left.length) {
            input[i] = left[p1];
            p1++;
            i++;
        }
        while (p2 < right.length) {
            input[i] = right[p2];
            p2++;
            i++;
        }

        return input;
    }

    public static void main(String[] args) {
        // var a1 = new int[] { 1, 4, 6 };
        // var a2 = new int[] { 2, 3, 5 };
        // var input = new int[a1.length + a2.length];
        // merge(input, a1, a2);
        // System.out.println(Arrays.toString(input));
        var arr1 = new int[] { 1, 2, 3, 4, 5 };
        var arr2 = new int[] { 5, 4, 3, 2, 1 };
        var arr3 = new int[] { 5, 4, 4, 2, 1 };
        sort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
