/**
 * LeetCode 704
 * 
 * https://leetcode.com/problems/binary-search/
 */

public class BinarySearch {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r)
            return -1;

        int m = (l + r) / 2;
        if (nums[m] == target)
            return m;
        if (nums[m] < target)
            return binarySearch(nums, target, m + 1, r);
        return binarySearch(nums, target, l, m - 1);
    }
}
