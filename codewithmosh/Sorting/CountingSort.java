import java.util.Arrays;

public class CountingSort {
    public static void sort(int[] arr, int max) {
        if (arr == null)
            return;

        var countArr = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            var key = arr[i];
            countArr[key]++;
        }

        var pointer = 0;
        for (int key = 0; key < countArr.length; key++) {
            var count = countArr[key];
            if (count != 0)
                for (int j = 0; j < count; j++) {
                    arr[pointer] = key;
                    pointer++;
                }
        }

        // compact implementation
        // int[] counts = new int[max + 1];
        // for (var item : array)
        // counts[item]++;

        // var k = 0;
        // for (var i = 0; i < counts.length; i++)
        // for (var j = 0; j < counts[i]; j++)
        // array[k++] = i;
    }

    public static void main(String[] args) {
        var arr1 = new int[] { 5, 4, 4, 2, 1 };
        sort(arr1, 5);
        System.out.println(Arrays.toString(arr1));

    }
}
