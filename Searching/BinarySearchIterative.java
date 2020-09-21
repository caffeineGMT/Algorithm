public class BinarySearchIterative {
    public static int search(int[] arr, int target) {
        if (arr == null)
            throw new IllegalArgumentException();

        var l = 0;
        var r = arr.length - 1;
        while (l <= r) {
            var middle = (l + r) / 2;
            if (target == arr[middle])
                return middle;
            if (target > arr[middle]) {
                l = middle + 1;
                continue;
            }
            if (target < arr[middle]) {
                r = middle - 1;
                continue;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 6, 7 };
        int index = search(numbers, 3);
        System.out.println(index);
    }

}
