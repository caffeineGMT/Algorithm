public class TernarySearch {
    public static int search(int[] arr, int target) {
        if (arr == null)
            throw new IllegalArgumentException();

        return search(arr, target, 0, arr.length - 1);
    }

    public static int search(int[] arr, int target, int l, int r) {
        if (l > r)
            return -1;

        var partitionSize = (r - l) / 3;
        var m1 = l + partitionSize;
        var m2 = r - partitionSize;
        if (target < arr[m1])
            return search(arr, target, l, m1 - 1);
        if (target == arr[m1])
            return m1;
        if (target > arr[m1] && target < arr[m2])
            return search(arr, target, m1 + 1, m2 - 1);
        if (target == arr[m2])
            return m2;
        if (target > arr[m2])
            return search(arr, target, m2 + 1, r);

        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 6, 7 };
        int index = search(numbers, 8);
        System.out.println(index);
    }
}
