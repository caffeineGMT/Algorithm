
/**
 * tutorial: https://www.youtube.com/watch?v=7h1s2SojIRw
 * analysis: https://www.youtube.com/watch?v=-qOVVRIZzao
 */

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null)
            return;
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        var pivot = partition1(arr, start, end);
        sort(arr, start, pivot - 1);
        sort(arr, pivot + 1, end);
    }

    private static int partition1(int[] arr, int small, int large) {
        var pivot = large;
        var s = small;
        var l = large - 1;

        while (s <= l) {
            while (s <= large - 1 && arr[s] <= arr[pivot])
                s++;
            while (l >= small && arr[l] > arr[pivot])
                l--;
            if (s < l) {
                swap(arr, s, l);
                s++;
                l--;
            }
        }

        swap(arr, s, pivot);

        return s;
    }

    private static int partition2(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;
        for (var i = start; i <= end; i++)
            if (array[i] <= pivot)
                swap(array, i, ++boundary);

        return boundary;
    }

    private static void swap(int[] arr, int a, int b) {
        var temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public static void main(String[] args) {
        var arr1 = new int[] { 4, 2, 1, 5, 3, 10, 8 };
        sort(arr1);
        // var result1 = partition1(arr1, 0, 4);
        // System.out.println(result1);
        System.out.println(Arrays.toString(arr1));

        // var arr2 = new int[] { 5, 4, 3, 2, 1 };
        // sort(arr2, 0, 4);
        // var result2 = partition1(arr2, 0, 4);
        // System.out.println(result2);
        // System.out.println(Arrays.toString(arr2));

        // var arr3 = new int[] { 1, 2, 3, 4, 5 };
        // sort(arr3, 0, 4);
        // var result3 = partition1(arr3, 0, 4);
        // System.out.println(result3);
        // System.out.println(Arrays.toString(arr3));

    }
}
