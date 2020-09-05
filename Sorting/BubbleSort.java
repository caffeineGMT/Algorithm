import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] arr) {
        boolean flag;
        for (int i = arr.length - 1; i >= 1; i--) {
            flag = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                    flag = false;
                }
            }
            if (flag)
                return;
        }
    }

    public void swap(int a, int b, int[] arr) {
        var temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    // public boolean isSorted(int[] arr) {

    // }

    public static void main(String[] args) {
        var test = new BubbleSort();
        var arr = new int[] { 50, 30, 30, 20 };
        test.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
