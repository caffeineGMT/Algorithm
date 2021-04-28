/**
 * LeetCode 159
 * 
 * https://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array/description
 * 
 * 分析: 本质上和first position of target是一样的题，只不过分割条件改变一下
 * 
 */

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int l = 0;
        int r = nums.length - 1;
        int target = nums[nums.length - 1];

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target)
                l = mid;
            else
                r = mid;
        }

        return Math.min(nums[l], nums[r]);
    }
}
