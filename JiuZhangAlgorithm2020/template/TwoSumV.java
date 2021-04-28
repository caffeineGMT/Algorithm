/**
 * LintCode 609
 * 
 * https://www.lintcode.com/problem/two-sum-less-than-or-equal-to-target/description
 * 
 */
public class TwoSumV {
    public int twoSum5(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return 0;

        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                count += r - l;
                l++;
            }
        }
        return count;
    }
}
