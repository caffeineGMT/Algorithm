public class BinarySearchTemplate {
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        // key1: start + 1 < end, 防止死循环
        while (start + 1 < end) {
            // key2：start + (end - start) / 2, in case of number representation overflow
            int mid = start + (end - start) / 2;
            // key3：=, <, > separate cases，mid does not plus 1 or minus 1, 防止紧张写错，属于没必要的优化
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // key4: deal with start and end after loop
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
