public class BinarySearchRecursive {
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (right < left) {
            return -1;
        }

        int middle = (left + right) / 2;
        if (target == arr[middle]) {
            return middle;
        }
        if (target < arr[middle]) {
            return binarySearchRecursive(arr, target, left, middle - 1);
        }
        return binarySearchRecursive(arr, target, middle + 1, right);
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 6, 7 };
        int index = binarySearchRecursive(numbers, 7);
        System.out.println(index);
    }

}