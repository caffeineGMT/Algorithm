/**
 * LintCode 587
 * 
 * https://www.lintcode.com/problem/two-sum-unique-pairs/description?_from=ladder&&fromId=161
 */

public class TwoSumUniquePairs {
    public int twoSum6(int[] nums, int target) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;
        int count = 0;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < target)
                l++;
            else if (sum > target)
                r--;
            else {
                count++;
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1])
                    l++;
            }
        }

        return count;
    }
}
