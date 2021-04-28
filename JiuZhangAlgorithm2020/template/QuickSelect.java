/**
 * LeetCode 215
 * 
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

public class QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end)
            return nums[start];

        int l = start;
        int r = end;
        int pivot = nums[(start + end) / 2];
        while (l <= r) {
            while (l <= r && nums[l] > pivot)
                l++;
            while (l <= r && nums[r] < pivot)
                r--;

            if (l <= r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }

        if (start + k - 1 <= r)
            return quickSelect(nums, start, r, k);
        if (start + k - 1 >= l)
            return quickSelect(nums, l, end, k - (l - start));

        return nums[r + 1];
    }
}