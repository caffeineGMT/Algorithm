
public class JumpSearch {
    public static int search(int[] arr, int target) {
        if (arr == null)
            return -1;

        var blockSize = (int) Math.sqrt(arr.length);
        var start = 0;
        var next = blockSize;
        while (start < arr.length && arr[next - 1] < target) {
            start = next;
            next += blockSize;
            if (next > arr.length)
                next = arr.length;
        }

        return linearSearch(arr, target, start, next - 1);
    }

    public static int linearSearch(int[] arr, int target, int l, int r) {
        for (int i = l; i <= r; i++)
            if (arr[i] == target)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5 };
        int index = search(numbers, 2);
        System.out.println(index);
    }
}
