/**
 * LintCode 585
 * 
 * https://www.lintcode.com/problem/maximum-number-in-mountain-sequence/solution
 */
public class MaxNumInMountainSequence {
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1])
                l = mid;
            else
                r = mid;
        }

        return Math.max(nums[l], nums[r]);
    }
}
