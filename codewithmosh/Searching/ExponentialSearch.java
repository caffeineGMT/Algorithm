public class ExponentialSearch {
    public static int search(int[] arr, int target) {

        var bound = 1;
        while (bound < arr.length && arr[bound] < target)
            bound *= 2;
        bound = Math.min(bound, arr.length - 1);

        return BinarySearchRecursive.binarySearchRecursive(arr, target, bound / 2, bound);
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 6, 7 };
        int index = search(numbers, 1);
        System.out.println(index);
    }
}
